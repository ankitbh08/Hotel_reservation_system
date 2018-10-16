package com.hrs.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrs.bo.HotelBo;
import com.hrs.bo.PaymentBo;
import com.hrs.dao.HotelDao;
import com.hrs.dao.PaymentDao;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.PaymentTo;
import com.hrs.to.ReservationDetailTo;
import com.hrs.to.UserTo;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	final Logger LOG = Logger.getLogger("PaymentController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doPost in PaymentController class");
		HttpSession session=request.getSession();
		System.out.println("51231211");
		PaymentTo pay=null;
		final PaymentBo paymentBo= new PaymentBo();
		String hotel_id=(String) session.getAttribute("hotel_id");
		System.out.println(hotel_id);
		PaymentDao pd=new PaymentDao();
		PaymentBo pb=new PaymentBo();
		PaymentTo paymentto=new PaymentTo();
		HotelBo hb=new HotelBo();
		ReservationDetailTo reserve=(ReservationDetailTo) session.getAttribute("reservationDetailTo_object");
		String booking_id=(String) session.getAttribute("booking_id");
		System.out.println(booking_id);
		String username=(String) session.getAttribute("username");
		paymentto.setCustomer_id(username);
		paymentto.setBooking_id(booking_id);
		paymentto.setCard_no((String) request.getParameter("number"));
		paymentto.setName_on_card((String) request.getParameter("fullname"));
		paymentto.setAccount_no((String) request.getParameter("accountnumber"));
		paymentto.setExpiry_date((String) request.getParameter("expiry"));
		paymentto.setCvv((String) request.getParameter("cvc"));
		paymentto.setCard_type((String) request.getParameter("contact"));
		paymentto.setPin((String) request.getParameter("zipcode"));
		paymentto.setBank_Name("State Bank Of India");
		Date date = new Date();
		paymentto.setPayment_date(date.toString());
		String payment_id=null;
		UserTo customerToLogin=(UserTo)session.getAttribute("userto_object");
		try {
			pay=paymentBo.makepayment(paymentto, booking_id, customerToLogin);
			
		} catch (DatabaseOperationException | ApplicationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		paymentto.setPayment_id(pay.getPayment_id());
		session.setAttribute("paymentto_object", paymentto);
		UserTo userTo=(UserTo) session.getAttribute("userto_object");
		
		System.out.println("this is payment controller");
		try {
			if(pay!=null){
				session.setAttribute("message1", "your booking done successfully!");
				session.setAttribute("payment_id", pay.getPayment_id());
				session.setAttribute("user_id", pay.getCustomer_id());
				
				hb.populate_room_availability(reserve, hotel_id, paymentto);
				RequestDispatcher dispatcher=request.getRequestDispatcher("payment_success.jsp");
				dispatcher.forward(request, response);
				LOG.info("Payment successfully completed");
			}
			else{
				request.setAttribute("message1", "payment unsuccessful....Please try again.");
				RequestDispatcher dispatcher=request.getRequestDispatcher("Payment Page.jsp");
				dispatcher.forward(request, response);
				LOG.info("Payment unsuccessful,redirected to same page.");

			}
		} catch (ApplicationException | DatabaseOperationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
