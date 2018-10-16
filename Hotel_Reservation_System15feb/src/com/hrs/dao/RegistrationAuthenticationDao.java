package com.hrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;







import org.apache.log4j.Logger;

import com.hrs.constants.QueryConstants;
import com.hrs.dbutil.DbUtil;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.CustomerTOLogin;
import com.hrs.to.RegistrationTo;
import com.hrs.to.UserTo;




public class RegistrationAuthenticationDao {
	final Logger LOG = Logger.getLogger("RegistrationAuthenticationDao");
	
	public RegistrationTo addUser(RegistrationTo userto) throws ApplicationException, DatabaseOperationException, SQLException {
		Connection connection=null;
		boolean res=false;
		try{
		connection=DbUtil.getConnection();
		
		String sql=QueryConstants.ADD_USER_REG;
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,userto.getCustomer_name());
		statement.setString(2,userto.getCustomer_name());
		statement.setString(3,userto.getCnfm_password());
		java.sql.Date date=new Date(userto.getDate_of_birth().getTime());
		statement.setDate(4,date);
		statement.setString(5,userto.getEmail());
		statement.setString(6,userto.getPhone());
		statement.setString(7,userto.getCountry());
		statement.setString(8,userto.getCity());
		statement.setString(9,userto.getPin_code());
		ResultSet result=statement.executeQuery();
		String s=null;
		int no=statement.executeUpdate();
		if(no>=1)
		{
			res=true;
			System.out.println("congratulations!! added successfully");
		}
			String sql1=QueryConstants.SELECT_PHONE;
			PreparedStatement statement1=connection.prepareStatement(sql1);
			statement1.setString(1,userto.getPhone());
			result=statement1.executeQuery();
			boolean c=result.next();
			if(c){
			s=result.getString("Customer_id");
			userto.setCustomer_id(s);
			

			System.out.println("your customer id is : "+s);
			}
			
			
			////////////////////////////////////////////////////////////////////////////////
		
			String sql2=QueryConstants.ADD_LOGIN_INFO;
			PreparedStatement statement2=connection.prepareStatement(sql2);
			statement2.setString(1,s);
			statement2.setString(2,userto.getPassword());
			ResultSet result2 = statement2.executeQuery();
			
			
			
			/////////////////////////////////////////////////////////////////////////////////
		
		if(connection!=null){
			connection.close();
		}
		 }catch (ClassNotFoundException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (IOException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (SQLException sqlException) {
			 LOG.error(sqlException);
			
			throw new DatabaseOperationException(sqlException);
		}
		finally{
			connection.close();
		}
		
		return userto;
	}
	
	public UserTo validateLogin(UserTo userTo) throws DatabaseOperationException, ApplicationException {
		Connection connection=null;
		ResultSet result=null;
		PreparedStatement statement=null;
		boolean res=false;
		try {
			
			connection=DbUtil.getConnection();
			//LOG.info("Hi this is validate method in DAO class");
		String sql=QueryConstants.GET_ROLE;
		statement=connection.prepareStatement(sql);
		
		statement.setString(1,userTo.getUsername());
		
		result=statement.executeQuery();
		
		boolean dataFound=result.next();
		
		if(dataFound){
		//	LOG.debug(userTo.toString());
			userTo.setRole(result.getString("role"));
			if(userTo.getPassword().equals(result.getString("password"))){
				res=true;
			}
		}
		else{
			//LOG.debug("user does not exists");
			System.out.println("user name does not exist");
		}
		
		
		
	} catch (ClassNotFoundException e) {
		 LOG.error(e);
		throw new ApplicationException(e);
	} catch (IOException e) {
		 LOG.error(e);
		throw new ApplicationException(e);
	} catch (SQLException sqlException) {
		 LOG.error(sqlException);
		throw new DatabaseOperationException(sqlException);
	}
		finally{
			
			if(connection!=null){
				try {
					result.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new DatabaseOperationException(e);
				}
				
				
			}
			
			
			
		}
		return userTo;

	}

	public boolean uniquePhone(String phone) throws ApplicationException, DatabaseOperationException, SQLException {
		boolean b=false;
		Connection connection=null;
		ResultSet result=null;
		PreparedStatement statement=null;
		try{
			connection=DbUtil.getConnection();
			//System.out.println("Connected");
			String sql=QueryConstants.SELECT_PHONE;
			statement=connection.prepareStatement(sql);
			statement.setString(1,phone);
			result=statement.executeQuery();
			
			boolean dataFound=result.next();
			
			if(dataFound){
				b=false;
			}
			else{
				b=true;
			}
			
			 }catch (ClassNotFoundException e) {
				 LOG.error(e);
				throw new ApplicationException(e);
			} catch (IOException e) {
				 LOG.error(e);
				throw new ApplicationException(e);
			} catch (SQLException sqlException) {
				 LOG.error(sqlException);
				throw new DatabaseOperationException(sqlException);
			}
			finally{
				result.close();
				statement.close();
				connection.close();
				
			}
		
		return b;
	}
	

	
	
	
	public void addCustomer_login_details(CustomerTOLogin ct)
			throws ApplicationException, DatabaseOperationException {
		 Connection connection=null;
		try {
			connection = DbUtil.getConnection();

			System.out.println("Connected");
			String sql = QueryConstants.INSERT_CUSTOMER;
			String userName = ct.getUsername();
			String password = ct.getPassword();
			String mobileNumber = ct.getMobileNumber();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, mobileNumber);
			statement.setString(2, userName);
			statement.setString(3, password);

			int no = statement.executeUpdate();
			
			if (no >= 1) {

				System.out.println("Record added successfully");
			} else {
				System.out.println("oops!! Something went wrong");
			}
			if (connection != null) {
				connection.close();
				statement.close();
			}
		} catch (ClassNotFoundException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (IOException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (SQLException e) {
			 LOG.error(e);
			throw new DatabaseOperationException(e);
		}

	}

	public boolean validateCustomer(CustomerTOLogin customerToLogin)
			throws ApplicationException, DatabaseOperationException {
		Connection connection=null;
		CustomerTOLogin customerTo = null;
		PreparedStatement statement=null;
		ResultSet result=null;
		boolean resultReturn = false;
		try {
			connection = DbUtil.getConnection();

			System.out.println("Connected");
			String sql = QueryConstants.VALIDATE_CUSTOMER;
			statement = connection.prepareStatement(sql);
			statement.setString(1, customerToLogin.getMobileNumber());
			statement.setString(2, customerToLogin.getUsername());
			statement.setString(3, customerToLogin.getPassword());
			result = statement.executeQuery();
			boolean datafound = result.next();
			if (datafound) {
				LOG.debug("debug of validation:Customer Found");
				resultReturn = true;
			}

			

		} catch (ClassNotFoundException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (IOException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (SQLException e) {
			 LOG.error(e);
			throw new DatabaseOperationException(e);
		}
		finally {

			try {
				statement.close();
				
				if (result != null) {
					result.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				 LOG.error(sqlException);
				new DatabaseOperationException(sqlException);
			}
		}

		return resultReturn;
	}
	
	public void addUser(UserTo userto) throws ApplicationException, DatabaseOperationException {
		PreparedStatement statement=null;
		Connection connection=null;
		try{
		connection=DbUtil.getConnection();
		
		String sql=QueryConstants.ADD_USER;
		String username=userto.getUsername();
		String password=userto.getPassword();
	
		
		statement=connection.prepareStatement(sql); 

		statement.setString(1, username);
		statement.setString(2, password);
	
		int no=statement.executeUpdate();
		if(no>=1)
		{
			System.out.println("congratulations!! added successfully");
		}
		
		} catch (ClassNotFoundException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (IOException e) {
			 LOG.error(e);
			throw new ApplicationException(e);
		} catch (SQLException sqlException) {
			 LOG.error(sqlException);
			throw new DatabaseOperationException(sqlException);
		}
		finally {

			try {
				statement.close();
				
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}

		
		
		
			
		
		
		
	}

	public boolean validateCustomer(UserTo userTo) throws ApplicationException, DatabaseOperationException, SQLException {
		
		Connection connection=null;
		ResultSet result=null;
		PreparedStatement statement=null;
		boolean res=false;
		try {
		connection=DbUtil.getConnection();
	
		String sql=QueryConstants.SELECT_CUSTOMER;
		statement=connection.prepareStatement(sql);
		
		statement.setString(1,userTo.getUsername());
		result=statement.executeQuery();
		boolean dataFound=result.next();
		if(dataFound){

		LOG.debug(userTo.toString());
		if(userTo.getPassword().equals(result.getString("password"))){
		res=true;
		}
		}
		else{
		LOG.debug("user does not exists");
		System.out.println("user name does not exist");
		}
		} catch (ClassNotFoundException e) {
			 LOG.error(e);
		throw new ApplicationException(e);
		} catch (IOException e) {
			 LOG.error(e);
		throw new ApplicationException(e);
		} catch (SQLException sqlException) {
			 LOG.error(sqlException);
		throw new DatabaseOperationException(sqlException);
		}
		finally{
		if(result!=null){
		result.close();
		}
		if(statement!=null){
		statement.close();
		}
		if(connection!=null){
		connection.close();
		}
		}

		return res;
	}

	public boolean validatePwd(String username, String password) throws DatabaseOperationException, ApplicationException{
		// TODO Auto-generated method stub
		boolean flag=false;
		
		 try {
		Connection connection5=null;
		ResultSet result5=null;
		PreparedStatement statement5=null;
		connection5=DbUtil.getConnection();
		String sql = "select * from login_info where userid=?";
		
			statement5=connection5.prepareStatement(sql);
		
		 statement5.setString(1,username);
		// statement.setString(2, pwd);
		result5=statement5.executeQuery();
		 String passworddb="";
		 String userid="";
		 while(result5.next()){
		 userid=result5.getString("userid");
		
		 passworddb=result5.getString("password");
		 String role=result5.getString("role");
		 //System.out.println(password);
		 }
		 
		 if(passworddb.equals(password))
		 {
			flag=true; 
			System.out.println("matched");
			  
		 }
		
	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseOperationException("Password doesn't match");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		}
		 return flag;
	}

	public CustomerTOLogin findName(UserTo user) throws ApplicationException, DatabaseOperationException {
		// TODO Auto-generated method stub
		Connection connection=null;
		ResultSet result=null;
		PreparedStatement statement=null;
		CustomerTOLogin cs=new CustomerTOLogin();
		boolean res=false;
		try {
		connection=DbUtil.getConnection();
	
		String sql=QueryConstants.FIND_NAME;
		statement=connection.prepareStatement(sql);
		
		statement.setString(1,user.getUsername());
		result=statement.executeQuery();
		boolean dataFound=result.next();
		if(dataFound){
			cs.setUsername(result.getString("customer_name"));
		LOG.debug("fetching username:"+cs.getUsername());
		
		}
		else{
		LOG.debug("user does not exists");
		
		}
		} catch (ClassNotFoundException e) {
			 LOG.error(e);
		throw new ApplicationException(e);
		} catch (IOException e) {
			 LOG.error(e);
		throw new ApplicationException(e);
		} catch (SQLException sqlException) {
			 LOG.error(sqlException);
		throw new DatabaseOperationException(sqlException);
		}
		finally{
		
		if(connection!=null){
			try {
				result.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseOperationException(e);
			}
			
		}
		}
		
		return cs;
	}

}
