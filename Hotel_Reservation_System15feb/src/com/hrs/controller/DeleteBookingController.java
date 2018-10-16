package com.hrs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrs.bo.HotelBo;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;

/**
 * Servlet implementation class DeleteBookingController
 */
public class DeleteBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookingController() {
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		HotelBo hotelBo=new HotelBo();
		RequestDispatcher dispatcher = null;
		String booking_id=request.getParameter("bookingID");
		
		try {System.out.println("hi");
			if(hotelBo.deleteBooking(booking_id)){
				System.out.println("hello");
				dispatcher=request.getRequestDispatcher("BookingCancel.jsp");
				dispatcher.forward(request, response);
			}
			else{
				
				request.setAttribute("message", "Booking is not cancelled....Please try again!");
				dispatcher=request.getRequestDispatcher("Cancellation.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ApplicationException | DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
