package com.hrs.bo;

import java.text.ParseException;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.hrs.dao.PaymentDao;
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
public class PaymentBo {
	
	final Logger LOG = Logger.getLogger("PaymentBo");
	PaymentDao paymentdao=null;
	/**
	 * 
	 */
	public PaymentBo(){
		paymentdao=new PaymentDao();
	}
	/**
	 * @param paymentto
	 * @param reservationDetailTo
	 * @param customerToLogin
	 * @return boolean value
	 * @throws ApplicationException
	 * @throws DatabaseOperationException
	 * @throws ParseException
	 */
	public PaymentTo makepayment(PaymentTo paymentto,String booking_id, UserTo customerToLogin) throws ApplicationException, DatabaseOperationException, ParseException {
		
		
		return paymentdao.makepayment(paymentto,booking_id,customerToLogin) ;
		
	}
	
	

		/**
		 * @param cno
		 * @return flag
		 */
		public  boolean ValidateCreditCard(String cno)
		{
			 boolean flag=false;
		 if(cno.length()==16){
			 if(cno.matches("[0-9]{16}"))
			{
				 flag=true;
			}
		 }
		 return flag;
		}
		/**
		 * @param cname
		 * @return flag
		 */
		public  boolean ValidateCardName(String cname)
		{
			 boolean flag=false;
			if(cname.length()<30){
				if(cname.matches("[A-Za-z]{1,30}"))
				{
					flag=true;
				}
		}
			return flag;
		}

		/**
		 * @param edate
		 * @return flag
		 */
		public  boolean ValidateExpiryDate(String edate)
		{
			 boolean flag=false;
			if(edate.matches("(0[1-9]|10|11|12)/[0-9]{2}$")){
				flag=true;
			}
			return flag;
		}
		/**
		 * @param cvv
		 * @return flag
		 */
		public  boolean ValidateCvvNumber(String cvv)
		{
			 boolean flag=false;
			if(cvv.length()==3){
				if(cvv.matches("[0-9]{3}"))
				{
					flag=true;
				}
			}
			return flag;
		}
		/**
		 * @param account_no
		 * @return flag
		 */
		public  boolean ValidateAccountNumber(String account_no)
		{
			 boolean flag=false;
			if(account_no.length()==10){
				if(account_no.matches("[0]{2}[0-9]{8}"))
				{
					flag=true;
				}
			}
			return flag;
		}
		/**
		 * @param pin
		 * @return flag
		 */
		public  boolean ValidatePin(String pin)
		{
			 boolean flag=false;
			if(pin.length()==4){
				if(pin.matches("[0-9]{4}"))
				{
					flag=true;
				}
			}
			return flag;
		}

		
		


	}
