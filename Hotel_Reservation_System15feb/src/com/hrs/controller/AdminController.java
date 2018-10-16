package com.hrs.controller;

import java.io.IOException;

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
import com.hrs.to.HotelTo;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	final Logger LOG = Logger.getLogger("AdminController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doPost in AdminController class");
		// TODO Auto-generated method stub
		String bar=request.getParameter("bar");
		final HotelBo hotelBo=new HotelBo();
		RequestDispatcher dispatcher = null;
		HttpSession session1=request.getSession();
		if(bar.equals("add")){
			
		
		HotelTo hotelTo=new HotelTo();
		String hotel_id=request.getParameter("hotel_id");
		String hotel_name =request.getParameter("hotel_name");
		String description=request.getParameter("description");
		int no_of_ac_rooms=Integer.parseInt(request.getParameter("no_of_ac_rooms"));
		int no_non_ac_rooms=Integer.parseInt(request.getParameter("no_non_ac_rooms"));
		int rate_ac_child=Integer.parseInt(request.getParameter("rate_ac_child"));
		int rate_non_ac_child=Integer.parseInt(request.getParameter("rate_non_ac_child"));
		int rate_ac_adult=Integer.parseInt(request.getParameter("rate_ac_adult"));
		int rate_non_ac_adult=Integer.parseInt(request.getParameter("rate_non_ac_adult"));
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		System.out.println("Hotel_id:"+hotel_id);
		System.out.println("Hotel_name:"+hotel_name);
		System.out.println("description:"+description);
		System.out.println("no_of_ac_rooms:"+no_of_ac_rooms);
		System.out.println("no_of_non_ac_rooms:"+no_non_ac_rooms);
		System.out.println("Rate ac_child:"+rate_ac_child);
		System.out.println("Rate ac_adult:"+rate_ac_adult);
		System.out.println("city:"+city);
		System.out.println("country:"+country);
		System.out.println(city.substring(0, 3).toUpperCase());
		System.out.println(country.substring(0, 3).toUpperCase());
		
		hotelTo.setCity(city.substring(0, 3).toUpperCase());
		hotelTo.setCountry(country.substring(0, 3).toUpperCase());
		hotelTo.setHotel_id(hotel_id);
		hotelTo.setHotel_name(hotel_name);
		hotelTo.setHotel_description(description);
		hotelTo.setNo_of_ac_rooms(no_of_ac_rooms);
		hotelTo.setNo_of_non_ac_rooms(no_non_ac_rooms);
		hotelTo.setRate_child_per_night_ac(rate_ac_child);
		hotelTo.setRate_child_per_night_non_ac(rate_non_ac_child);
		hotelTo.setRate_adult_per_night_ac(rate_ac_adult);
		hotelTo.setRate_adult_per_night_non_ac(rate_non_ac_adult);
		
		
		
		try {
			if(hotelBo.addHotel(hotelTo)){
				request.setAttribute("message", "Hotel Successfully added");
				dispatcher=request.getRequestDispatcher("admin_addHotel.jsp");
				LOG.info("Hotel details are succesfully added");
			}
			else{
				request.setAttribute("message", "Hotel is not added, Something went wrong");
				dispatcher=request.getRequestDispatcher("admin_add_hotel_fail.jsp");
				LOG.info("Hotel details could not be added ndue to some error");
			}
			
			dispatcher.forward(request,response);
		
		} catch (DatabaseOperationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request, response);
		} catch (ApplicationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request, response);
		}
		}
		else if(bar.equals("edit")){
			String hotelId=request.getParameter("hotel_id");
			HotelTo hotelto=new HotelTo();
			hotelto.setHotel_id(hotelId);
	        try {
				HotelTo hotel=hotelBo.findHotel(hotelto);
				System.out.println(hotel.getHotel_name());
				request.setAttribute("description", hotel.getHotel_description());
				request.setAttribute("message","edit your hotels here");
				request.setAttribute("hotel_name",hotel.getHotel_name());
				request.setAttribute("hotel_id", hotel.getHotel_id());
				request.setAttribute("country", hotel.getCountry());
				request.setAttribute("city", hotel.getCity());
				request.setAttribute("non_ac_rooms", hotel.getNo_of_non_ac_rooms());
				request.setAttribute("ac_rooms", hotel.getNo_of_ac_rooms());
				dispatcher=request.getRequestDispatcher("admin_edit_hotel.jsp");
				dispatcher.forward(request, response);
				LOG.info("Admin details edited successfully");
			} catch (ApplicationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseOperationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
		
		else if(bar.equals("edited")){
			HotelTo hotelTo=new HotelTo();
			String idd=request.getParameter("hotel_id");
			int no_of_ac_rooms=Integer.parseInt(request.getParameter("no_of_ac_rooms"));
			int no_non_ac_rooms=Integer.parseInt(request.getParameter("no_non_ac_rooms"));
			int rate_ac_child=Integer.parseInt(request.getParameter("rate_ac_child"));
			int rate_non_ac_child=Integer.parseInt(request.getParameter("rate_non_ac_child"));
			int rate_ac_adult=Integer.parseInt(request.getParameter("rate_ac_adult"));
			int rate_non_ac_adult=Integer.parseInt(request.getParameter("rate_non_ac_adult"));
			
			hotelTo.setHotel_id(idd);
			hotelTo.setNo_of_ac_rooms(no_of_ac_rooms);
			hotelTo.setNo_of_non_ac_rooms(no_non_ac_rooms);
			hotelTo.setRate_child_per_night_ac(rate_ac_child);
			hotelTo.setRate_child_per_night_non_ac(rate_non_ac_child);
			hotelTo.setRate_adult_per_night_ac(rate_ac_adult);
			hotelTo.setRate_adult_per_night_non_ac(rate_non_ac_adult);
			
			try {
				if(hotelBo.editHotel(hotelTo)){
					request.setAttribute("success", "Hotel details upadated successfully");
					dispatcher=request.getRequestDispatcher("admin_edit_hotel.jsp");
					dispatcher.forward(request, response);
					LOG.info("Hotel details upadated successfully");
				}
				else{
					request.setAttribute("success", "Something went wrong , can't perform the action");
					dispatcher=request.getRequestDispatcher("admin_edit_hotel.jsp");
					dispatcher.forward(request, response);
					LOG.info("Problem encountered!!could not edit hotel details");
				}
			} catch (DatabaseOperationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(bar.equals("delete")){
			String id =request.getParameter("hotel_id");
			HotelTo hotelTo=new HotelTo();
			hotelTo.setHotel_id(id);
			 
			try {
				HotelTo hotel=hotelBo.findHotel(hotelTo);
				System.out.println(hotel.getHotel_name());
				request.setAttribute("description", hotel.getHotel_description());
				request.setAttribute("message","delete you hotels");
				request.setAttribute("hotel_name",hotel.getHotel_name());
				request.setAttribute("hotel_id", hotel.getHotel_id());
				request.setAttribute("country", hotel.getCountry());
				request.setAttribute("city", hotel.getCity());
				request.setAttribute("non_ac_rooms", hotel.getNo_of_non_ac_rooms());
				request.setAttribute("ac_rooms", hotel.getNo_of_ac_rooms());
				dispatcher=request.getRequestDispatcher("admin_delete_hotel.jsp");
				
				dispatcher.forward(request, response);
				} catch (DatabaseOperationException e) {
					LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if(bar.equals("deleted")){
			HotelTo hotel=new HotelTo();
			String id_of_hotel=(String) session1.getAttribute("id_of_hotel");
		    hotel.setHotel_id(id_of_hotel);
			try {
				if(hotelBo.deleteHotel(hotel)){
					request.setAttribute("message", "Message is successfully deleted");
					dispatcher=request.getRequestDispatcher("admin_deleted_hotel.jsp");
					dispatcher.forward(request, response);
					
				}
				else{
					request.setAttribute("message","No Such Hotel is there");
					dispatcher=request.getRequestDispatcher("search_admin.jsp");
					dispatcher.forward(request, response);
				}
			} catch (DatabaseOperationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



}
