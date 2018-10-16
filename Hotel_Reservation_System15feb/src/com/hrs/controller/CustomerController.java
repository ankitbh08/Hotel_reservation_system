package com.hrs.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hrs.bo.AuthenticationBo;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.RegistrationTo;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	final Logger LOG = Logger.getLogger("CustomerController");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doPost in CustomerController class");
		// TODO Auto-generated method stub
		RegistrationTo registerTo=new RegistrationTo();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String confirm_password=request.getParameter("confirm_password");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date_of_birth = null;
		System.out.println(request.getParameter("date_of_birth"));
		try {
			date_of_birth=sdf.parse(request.getParameter("date_of_birth"));
		} catch (ParseException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phoneNumber=request.getParameter("contact_number");
		String email_address=request.getParameter("email_address");
		String country=request.getParameter("country");
		String city=request.getParameter("city");
		String pin_code=request.getParameter("pin");
		
		registerTo.setCustomer_name(name);
		registerTo.setPassword(password);
		registerTo.setCnfm_password(confirm_password);
		registerTo.setDate_of_birth(date_of_birth);
		registerTo.setCountry(country);
		registerTo.setCity(city);
		registerTo.setPhone(phoneNumber);
		registerTo.setEmail(email_address);
		registerTo.setPin_code(pin_code);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("customer_name",registerTo.getCustomer_name());
		
		 RequestDispatcher dispatcher = null;
		 
		 final AuthenticationBo authenticationBo=new AuthenticationBo();
		
		 RegistrationTo registerToR=null;
		 try {
			 
			 registerToR=authenticationBo.addUser(registerTo);
			 System.out.println(registerToR.getCustomer_id());
			if(registerToR.getCustomer_id()!=null){
				request.setAttribute("message",registerToR.getCustomer_id());
				 dispatcher=request.getRequestDispatcher("register_success.jsp");
				 LOG.info("User registered successfully");
				 }
			else{
				request.setAttribute("message", "OOPs something went wrong , you have to register yourself again!!");
				dispatcher=request.getRequestDispatcher("register_user.jsp");
				LOG.info("Registeration fails.hence,redirected to same page");
			}
			dispatcher.forward(request,response);
		} catch (ApplicationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request, response);
		} catch (DatabaseOperationException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			LOG.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			dispatcher.forward(request, response);
		}
		}

}
