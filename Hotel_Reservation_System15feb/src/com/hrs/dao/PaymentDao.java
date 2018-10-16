package com.hrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import com.hrs.constants.QueryConstants;
import com.hrs.dbutil.DbUtil;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.CustomerTOLogin;
import com.hrs.to.PaymentTo;
import com.hrs.to.RegistrationTo;
import com.hrs.to.ReservationDetailTo;
import com.hrs.to.UserTo;
/**
 * @author 
 *
 */
public class PaymentDao {
	
	
	/**
	 * @param paymentTo
	 * @param reservationDetailTo
	 * @param customerToLogin
	 * @return boolean value
	 * @throws ApplicationException
	 * @throws DatabaseOperationException
	 * @throws ParseException
	 */
	public PaymentTo makepayment(PaymentTo paymentTo,String booking_id, UserTo customerToLogin) throws ApplicationException, DatabaseOperationException, ParseException {
		boolean res=false;
		Connection connection=null;
		PreparedStatement statement;
		
		
		try{
			 connection = DbUtil.getConnection();
		
		String sql=QueryConstants.MAKE_PAYMENT;
		statement=connection.prepareStatement(sql);
		
		statement.setString(1,booking_id);
		statement.setString(2,customerToLogin.getUsername());
		statement.setString(3,paymentTo.getCard_no());
		statement.setString(4,paymentTo.getCard_type());
		statement.setString(5,paymentTo.getName_on_card());
		statement.setString(6,paymentTo.getExpiry_date());
//		
		statement.setString(7,paymentTo.getCvv());
		statement.setInt(8,Integer.parseInt(paymentTo.getAccount_no()));
		statement.setInt(9,Integer.parseInt(paymentTo.getPin()));
		
		java.util.Date paydate=new java.util.Date();
		java.sql.Date paymentDate=new Date(paydate.getTime());
		statement.setDate(10,paymentDate);
		int no=statement.executeUpdate();
		if(no>=1)
		{
			
			String payment_id =paymentIdGenerator(booking_id);
			paymentTo.setPayment_id(payment_id);
			res=true;
		}
		if(connection!=null){
			connection.close();
			statement.close();
		}
		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new DatabaseOperationException(sqlException);
		}
		paymentTo.setBooking_id(booking_id);
		paymentTo.setCustomer_id(customerToLogin.getUsername());
	return paymentTo;
		}
	/**
	 * @param reservationDetailTo
	 * @return payment_id
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public String paymentIdGenerator(String booking_id) throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		String sql1=QueryConstants.GET_TRANSACTION_ID;
		Connection connection=null;
		String s = null;
		try {
			connection = DbUtil.getConnection();
			statement=connection.prepareStatement(sql1);
			statement.setString(1,booking_id);
			ResultSet result1 = statement.executeQuery();
			if(result1.next()){
			s=result1.getString("payment_id");
			
			if(connection!=null){
				result1.close();
				connection.close();
				statement.close();
			}
			
			
			}
		}
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseOperationException("SQl Exception in getting payment id");
			
		}
		catch (ClassNotFoundException e) {
  			// TODO Auto-generated catch block
  			throw new ApplicationException("Application Exception found in room availibilty");
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			throw new ApplicationException("Application Exception found in room availibilty");
  		}
		return s;
	}
	}

