package com.hrs.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.hrs.dao.RegistrationAuthenticationDao;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.CustomerTOLogin;
import com.hrs.to.RegistrationTo;
import com.hrs.to.UserTo;



public class AuthenticationBo {
	final Logger LOG = Logger.getLogger("AuthenticationBo");
	
	static int i=1000;
	
	RegistrationAuthenticationDao userdao=null;
	
	public AuthenticationBo(){
		userdao=new RegistrationAuthenticationDao();
	}
	

	
	public RegistrationTo addUser(RegistrationTo userto) throws ApplicationException, DatabaseOperationException, SQLException{
		 return userdao.addUser(userto);
	}
	
	public boolean validateName(String name){
		boolean b=false;
		
		
		if(name.matches("[A-Za-z]{1,}")){
			b=true;
		}
		
		return b;
	}
	
	public String generateId(RegistrationTo userTo){
		 	 
			 
			 String first_char=userTo.getCustomer_name().substring(0, 1).toUpperCase();
			 StringBuffer sb=new StringBuffer();
			 sb.append(first_char);
			 String s=""+i;
			 sb.append(s);
			 return sb.toString();
			 
	}
	
	
	public boolean matchPassword(String password,String s){
		boolean b=false;
		if(password.equals(s)){
			b=true;
		}
		
		return b;
	}
	
	public boolean validatePassword(String password,String name){
		boolean b=false;
		
		if(password.length()>0 && password.length()<25){
			if(password.contains(name)){
				b=false;
			}
			else{
				String p1="[!@#$%^&*]{1}";
				String p2="[0-9]{1}";
				Pattern p11=Pattern.compile(p1);
				Pattern p22=Pattern.compile(p2);
				Matcher m11=p11.matcher(password);
				Matcher m22=p22.matcher(password);
				if(m11.find() && m22.find()){
					b=true;
				}
			}
		}
	
		return b;
		
	}
	
	public boolean validateDOB(java.util.Date date11){
		
		boolean b=false;
		
		LocalDate date1 = date11.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate date=LocalDate.now();
		if(date1.isBefore(date)){
			b=true;
		}
		
		return b;
	}
	
	public boolean validateEmail(String email){
		
		boolean b=false;
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        b=(m.matches() && email.endsWith(".com"));
		return b;
	}
	
	public boolean validatePhone(String phone){
		
		boolean b=false;
		
		if(phone.substring(0, 3).equals("+91") && phone.substring(3,phone.length()).matches("[789]{1}[0-9]{9}")){
			b=true;
		}
		
		return b;
	}
	
	public boolean uniquePhone(String phone) throws ApplicationException, DatabaseOperationException, SQLException{
		return userdao.uniquePhone(phone);
		
	}
	public boolean validatePin(String pin){
		
		boolean b=false;
		
		
		if(pin.matches("[1-9]{1}[0-9]{5}")){
			b=true;
		}
		
		return b;
	}
	public UserTo validateLogin(UserTo userTo) throws DatabaseOperationException, ApplicationException{
		return userdao.validateLogin(userTo);
		
	}
	public void addUser(UserTo userto) throws ApplicationException, DatabaseOperationException{
		userdao.addUser(userto);
	}
	
	public boolean validateCustomer(UserTo userTo) throws ApplicationException, DatabaseOperationException, SQLException {
		
		
		return userdao.validateCustomer(userTo);
	}

	public boolean validatePwd(String username, String password) throws DatabaseOperationException, ApplicationException
	{
		return userdao.validatePwd(username,password);
	}
	public CustomerTOLogin findName(UserTo user) throws ApplicationException, DatabaseOperationException{
		return userdao.findName(user);
	}
}
