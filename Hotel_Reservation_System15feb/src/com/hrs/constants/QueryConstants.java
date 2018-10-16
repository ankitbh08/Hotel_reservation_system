package com.hrs.constants;

public class QueryConstants {

	public static final String INSERT_CUSTOMER="insert into customer_login values(?,?,?)";
	public static final String VALIDATE_CUSTOMER="select mobile_number,username,password from customer_login where mobile_number=? and username=? and password=?";
	public static final String INVALID_credential = "Invalid Credential";
	
	/*admin login*/
	public static final String ADD_USER="insert into admin_details values(?,?)";
	public static final String SELECT_PASSWORD="select login_id,password from admin_details where login_id=? and password=?";
	public static final String ADD_HOTEL="insert into Hotel_Details values(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String EDIT_HOTEL= "update Hotel_Details set no_of_ac_rooms=?,no_of_non_ac_rooms=?,rate_child_per_night_ac=?,rate_child_per_night_non_ac=?,rate_adult_per_night_ac=?,rate_adult_per_night_non_ac=?  where hotel_id = ?";
    public static final String DELETE_HOTEL = "delete from Hotel_details where hotel_id = ?";


   
    // Registration and Authentication
    public static final String ADD_USER_REG="insert into customer_details values(concat(UPPER(substr(?,1,1)),reg_seq.nextval),?,?,?,?,?,?,?,?)";
	public static final String SELECT_PASSWORD_REG="select customer_id,password from customer_details where Customer_id=?";
	public static final String SELECT_PHONE="select customer_id from customer_details where phone=?";
	public static final String GET_DETAILS="select * from customer_details where customer_id=? && password=?";
	public static final String SELECT_CUSTOMER="select customer_id,password from customer_details where Customer_id=?";
	//search hotel
	
	public static final String SEARCH_HOTEL="select hd.Hotel_id,hd.Hotel_name,hd.Hotel_description,hd.rate_Adult_per_night_AC from Hotel_Details hd join country c on hd.country=c.id join city ci on hd.city=ci.id where c.name=? and ci.name=?";

	// Book Hotel
	public static final String BOOK_HOTEL="Insert into booking_details values(concat ('BKNG',booking_seq.nextval),?,?,?,?,?,?,?,?,?,?)";
	public static final String FIND_ID="select booking_id from booking_details where customer_id=? and check_in_date=? and hotel_id=?";
	
	// Payment
	public static final String MAKE_PAYMENT="Insert into payment_details values(concat('TRAN',transaction_seq.nextval),?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_TRANSACTION_ID="select payment_id from payment_details where booking_id=?";
	//genration of date of birth
	public static final String DATE_OF_BIRTH="select date_of_birth from customer_details where customer_id=?";
	
	//Room availibilty Query
	
	public static final String ROOM_AVAILIBITY_MATCHING="select * from room_availibility where hotel_id=?";
	public static final String INSERT_ROOM_AVAILABILITY="insert into room_availibility values(?,?,?,?,?,?,?,?,?,?)";
	
	//
	public static final String GET_HOTEL="select * from Hotel_details where hotel_id=?";
	//GET rOLE
	public static final String GET_ROLE="select role,userid,password from login_info where userid  = ?";
	
	 //Add to table login_info
    public static final String ADD_LOGIN_INFO="insert into login_info values('customer',?,?)";
    
    //LOG
    public static final String LOG4J_FILE = "/WEB-INF/log4j.properties";
    		
    //CancelBooking
    public static final String DELETE_BOOKING="delete from booking_details where booking_id=?";
    public static final String DELETE_BOOKING_PAYMENTDETAILS = "delete from payment_details where booking_id=?";
	
    public static final String FIND_NAME = "select customer_name from customer_details where customer_id=?"; 

    
}

//LOG

