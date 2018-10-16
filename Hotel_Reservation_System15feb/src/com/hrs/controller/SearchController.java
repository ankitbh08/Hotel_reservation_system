package com.hrs.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.hrs.exceptions.BusinessException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.HotelSearchTO;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	final Logger LOG = Logger.getLogger("SearchController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doPost in SearchController class");
		// TODO Auto-generated method stub
		HotelSearchTO hotelsearchTo=new HotelSearchTO();
		String country=request.getParameter("country");
		String city=request.getParameter("city");
		hotelsearchTo.setCountry(country);
		hotelsearchTo.setCity(city);
		HttpSession session=request.getSession();
		session.setAttribute("country", hotelsearchTo.getCountry());
		session.setAttribute("city", hotelsearchTo.getCity());
		
		 List<HotelSearchTO> hotelList=new ArrayList();
		 RequestDispatcher dispatcher = null;
		 final HotelBo hotelBo=new HotelBo();
		 
		 try {
			hotelList=hotelBo.searchHotel(hotelsearchTo);
			session.setAttribute("hotel_list", hotelList);
			for(HotelSearchTO h:hotelList){
				System.out.println(h.toString());
			}
			if(!hotelList.isEmpty()){
				request.setAttribute("message",hotelsearchTo.getCity());
				request.setAttribute("hotelList", hotelList);
				dispatcher=request.getRequestDispatcher("SearchPage.jsp");
				LOG.info("Hotels searched on the basis of country and city");
			}
			else{
				request.setAttribute("message",hotelsearchTo.getCountry()+" ,"+hotelsearchTo.getCity());
				dispatcher=request.getRequestDispatcher("Search_Page_customer_fail.jsp");
				LOG.info("No hotels available at the mentioned location");
			}
			dispatcher.forward(request,response);
		} catch (ApplicationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request,response);
		} catch (DatabaseOperationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request,response);
		} catch (BusinessException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request,response);
		}
	}

}
