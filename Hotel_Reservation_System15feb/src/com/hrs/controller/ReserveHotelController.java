package com.hrs.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrs.bo.HotelBo;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.HotelSearchTO;
import com.hrs.to.RegistrationTo;
import com.hrs.to.ReservationDetailTo;
import com.hrs.to.UserTo;

/**
 * Servlet implementation class ReserveHotelController
 */
public class ReserveHotelController extends HttpServlet {
	final Logger LOG = Logger.getLogger("ReserveHotelController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveHotelController() {
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
		LOG.info("Inside - method doPost in ReserveHotelController class");
		
		HttpSession session=request.getSession();
		HotelBo hotelBo=new HotelBo();
		String country=null;
		String city=null;
		UserTo userTo=(UserTo) session.getAttribute("userto_object");
		ReservationDetailTo reservationDetailTo=new ReservationDetailTo();
		RequestDispatcher dispatcher = null;
		if(session.getAttribute("country")!=null && session.getAttribute("city")!=null){
			country=(String) session.getAttribute("country");
			city=(String) session.getAttribute("city");
		}
		else{
			country= request.getParameter("country");
			city=request.getParameter("city");
		}
		String cust_id=(String) session.getAttribute("username");
		System.out.println(cust_id);
		String hotel_id=(String) session.getAttribute("hotel_id");
		String date = request.getParameter("check_date");
		System.out.println(date);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
			Date check_in_date=null;
			Date check_out_date=null;
			try {
				check_in_date = sdf1.parse(date);
			} catch (ParseException e1) {
				LOG.error(e1);
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		 java.sql.Date date1=new java.sql.Date(check_in_date.getTime());
		String date2=request.getParameter("checkout_date");
		
		System.out.println(date2);
		try {
			check_out_date = sdf1.parse(date2);
		} catch (ParseException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String room_type=request.getParameter("room_type");
		
		
		int rooms=Integer.parseInt(request.getParameter("no_of_rooms"));
		int adults=Integer.parseInt(request.getParameter("no_of_adults"));
		int children=Integer.parseInt(request.getParameter("no_of_children"));
		String booking_id="";

		reservationDetailTo.setCheck_in_date(check_in_date);
		reservationDetailTo.setCheck_out_date(check_out_date);
		reservationDetailTo.setNo_of_adults(adults);
		reservationDetailTo.setNo_of_children(children);
		reservationDetailTo.setRoom_type(room_type);
		reservationDetailTo.setTotal_rooms(rooms);
		 
		try {
			
			reservationDetailTo=hotelBo.reserveHotel(hotel_id,cust_id,reservationDetailTo);
			booking_id=reservationDetailTo.getBooking_id();
			session.setAttribute("booking_id", booking_id);
			session.setAttribute("reservationDetailTo_object", reservationDetailTo);
		
		} catch (DatabaseOperationException e) {
			LOG.error(e);
		}
		
		List<HotelSearchTO> list=(List<HotelSearchTO>) session.getAttribute("hotel_list");
		HotelSearchTO hotel=null;
		
		for(HotelSearchTO h:list){
			if(hotel_id.equals(h.getHotel_id())){
				System.out.println(h.getHotel_id());
				hotel=h;
				System.out.println("this is for loop"+h.getHotel_id());
				break;
			}
		}
		RegistrationTo userTo1=(RegistrationTo) session.getAttribute("registrationTo_object");
		
		
		try {
			reservationDetailTo.setTotal_price(hotelBo.pricecalculator(room_type,adults,children,rooms,hotel,userTo1,cust_id));
		} catch (DatabaseOperationException | ApplicationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			if(hotelBo.check_availibilty(reservationDetailTo, hotel_id)){
				session.setAttribute("price", reservationDetailTo.getTotal_price());
				session.setAttribute("reservationDetailsTo_object", reservationDetailTo);
				dispatcher=request.getRequestDispatcher("PaymentInterface.jsp");
				dispatcher.forward(request, response);
				LOG.info("payment amount to be paid is shown");
			}
			else{
				 request.setAttribute("message","sorry!!no rooms are available for room type you searched");
				 dispatcher = request.getRequestDispatcher("Search_Page_customerlogin.jsp");
				 dispatcher.forward(request, response);
				 LOG.info("No rooms availble for the search page so,user is redirtected search page");
			}
		} catch (ApplicationException | DatabaseOperationException e) {
			LOG.error(e);
		}
	}

}
