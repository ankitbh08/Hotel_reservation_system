package com.hrs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrs.to.HotelSearchTO;

/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	final Logger LOG = Logger.getLogger("BookingController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
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
		LOG.info("Inside - method doPost in BookingController class");
		// TODO Auto-generated method stub
		int i=Integer.parseInt(request.getParameter("book_selection"));
		HttpSession session=request.getSession();
		List<HotelSearchTO> hList=(List<HotelSearchTO>)session.getAttribute("hotel_list");
		HotelSearchTO hotel=hList.get(i);
		System.out.println(hotel);
		session.setAttribute("HotelSearchTo_object", hotel);
		System.out.println(hotel.getHotel_id());
		
		String username=(String)session.getAttribute("username");
		System.out.println(username);
		session.setAttribute("hotel_id", hotel.getHotel_id());
		if(username==null){
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			LOG.info("Since user is not logged in redirected to login page");
		}
		else{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Reserve-Hotel.jsp");
			dispatcher.forward(request, response);
			LOG.info("user required to enter reservation details");
		}
		
	}

}
