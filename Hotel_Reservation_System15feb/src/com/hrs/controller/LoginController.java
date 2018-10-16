package com.hrs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;







import javax.xml.ws.RequestWrapper;

import org.apache.log4j.Logger;

import com.hrs.bo.AuthenticationBo;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.CustomerTOLogin;
import com.hrs.to.HotelSearchTO;
import com.hrs.to.UserTo;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger LOG = Logger.getLogger("LoginController");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doPost in LoginController class");
		// TODO Auto-generated method stub
		UserTo userTo = new UserTo();
		String username = request.getParameter("username");// Username entered
		// by the user in the login page
		String password = request.getParameter("password");// Password entered
		// by the user in the login page
		userTo.setUsername(username);
		userTo.setPassword(password);
		/*LOG.info("Login servlet invoked UserName:" + userid + "Password:"
				+ passWord);*/
		
		HttpSession session = request.getSession();
		 RequestDispatcher dispatcher = null;
		 final AuthenticationBo authenticationBo=new AuthenticationBo(); //Creates an Object of AuthenticationBo
		
		 UserTo user=null;
		CustomerTOLogin cs=null;
		
			 
			 try {
				 user = authenticationBo.validateLogin(userTo);
				 cs=authenticationBo.findName(user);
				 session.setAttribute("customer_name", cs.getUsername());
				 LOG.debug("Admin Logged-in");
				 
				if(user.getRole().equalsIgnoreCase("customer") && authenticationBo.validatePwd(username, password)){
					
					 session.setAttribute("username",userTo.getUsername());
					 session.setAttribute("userto_object", userTo);
					 String hotel_id=(String) session.getAttribute("hotel_id");
					 if(hotel_id==null){
						 
					
					dispatcher=request.getRequestDispatcher("search_login.jsp");
					dispatcher.forward(request, response);
					LOG.info("moving to search page after login");
					 }
					 else{
						 dispatcher=request.getRequestDispatcher("Reserve-Hotel.jsp");
							dispatcher.forward(request, response);
							LOG.info("moving to reserve page after login");
					 }
					 
					 System.out.println(hotel_id);
				 
				}
				 else if(user.getRole().equalsIgnoreCase("admin")&& authenticationBo.validatePwd(username, password)){
						 dispatcher = request.getRequestDispatcher("search_admin.jsp");
						 
						 session.setAttribute("username",userTo.getUsername());
						 dispatcher.forward(request, response);
						 LOG.info("moving to search hotel page for admin");
					 
						 
					 	}
 
				 else {
					 
					 request.setAttribute("message","Invalid Username or Password");
					 dispatcher = request.getRequestDispatcher("login.jsp");
					 dispatcher.forward(request, response);
					 LOG.info("USer entered wrong login details!login failed");
				 }
			} catch (DatabaseOperationException | ApplicationException  | NullPointerException e) {
				LOG.error(e);
				request.setAttribute("message","Invalid Username or Password");
				 dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
				// TODO Auto-generated catch block
				System.out.println("Error");
				LOG.error(e);
			} 
			 
			 
			
		}
}
		
		
	


