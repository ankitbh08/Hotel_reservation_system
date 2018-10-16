package com.hrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;











import org.apache.log4j.Logger;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.hrs.constants.QueryConstants;
import com.hrs.dbutil.DbUtil;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.BusinessException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.CustomerTOLogin;
import com.hrs.to.HotelSearchTO;
import com.hrs.to.HotelTo;
import com.hrs.to.PaymentTo;
import com.hrs.to.RegistrationTo;
import com.hrs.to.ReservationDetailTo;
import com.hrs.to.RoomAvailabiltyTo;
import com.hrs.to.UserTo;



/**
 * @author 
 *
 */
public class HotelDao {
	
	final Logger LOG = Logger.getLogger("HotelDao");
	
	 
	/**
	 * @param hotelTo
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public boolean addHotel(HotelTo hotelTo) throws DatabaseOperationException, ApplicationException {
		Connection connection=null;
		PreparedStatement statement=null;
		boolean res=false;
		try{
			connection=DbUtil.getConnection();
			
			String sql=QueryConstants.ADD_HOTEL;
			
			statement=connection.prepareStatement(sql);
			
			statement.setString(1,hotelTo.getHotel_id());
			statement.setString(2,hotelTo.getHotel_name());
			statement.setString(3,hotelTo.getHotel_description());
			statement.setString(4,hotelTo.getCountry());
			statement.setString(5,hotelTo.getCity());
			statement.setInt(6,hotelTo.getNo_of_ac_rooms());
			statement.setInt(7,hotelTo.getNo_of_non_ac_rooms());
			statement.setInt(8,hotelTo.getRate_child_per_night_ac());
			statement.setInt(9,hotelTo.getRate_child_per_night_non_ac());
			statement.setInt(10,hotelTo.getRate_adult_per_night_ac());
			statement.setInt(11,hotelTo.getRate_adult_per_night_non_ac());
			
			int no=statement.executeUpdate();
			if(no>=1)
			{
				res=true;
				System.out.println("congratulations!! added successfully");
			}
			if(connection!=null){
				connection.close();
				statement.close();
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
		
		return res;
	}

	/**
	 * @param hotelTo
	 * @throws ApplicationException
	 * @throws DatabaseOperationException
	 */
	public boolean editHotel(HotelTo hotelTo) throws ApplicationException, DatabaseOperationException {
		PreparedStatement statement=null;
		Connection connection = null;
		boolean res=false;
		try{
			connection=DbUtil.getConnection();
			
		    String sql=QueryConstants.EDIT_HOTEL;
	        System.out.println("changed details");
			statement=connection.prepareStatement(sql);
			
		
			statement.setInt(1,hotelTo.getNo_of_ac_rooms());
			statement.setInt(2,hotelTo.getNo_of_non_ac_rooms());
			statement.setInt(3,hotelTo.getRate_child_per_night_ac());
			statement.setInt(4,hotelTo.getRate_child_per_night_non_ac());
			statement.setInt(5,hotelTo.getRate_adult_per_night_ac());
			statement.setInt(6,hotelTo.getRate_adult_per_night_non_ac());
			statement.setString(7,hotelTo.getHotel_id());
			
			int no=statement.executeUpdate();
			if(no>=1)
			{
				res=true;
				LOG.info(" hotel details edited successfully" );
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
				
				
				if (connection != null) {
					connection.close();
					statement.close();
				}
			} catch (SQLException sqlException) {
				LOG.error(sqlException);
				new DatabaseOperationException(sqlException);
			}
		}
		return res;
	}
	
	
	public boolean deleteHotel(HotelTo hotelTo) throws ApplicationException, DatabaseOperationException {
		PreparedStatement statement=null;
		Connection connection = null;
		boolean res=false;
		try{
			connection=DbUtil.getConnection();
			
			String sql=QueryConstants.DELETE_HOTEL;
			
		
			String hotel_id=hotelTo.getHotel_id();
			
	
			statement=connection.prepareStatement(sql);
			System.out.println("Connection set");
			
			statement.setString(1,hotel_id);
			
			int no=statement.executeUpdate();
			if(no>=1)
			{
				res=true;
				LOG.info("congratulations!! hotel deleted successfully");
			}
			
			} catch (ClassNotFoundException e) {
				throw new ApplicationException(e);
			} catch (IOException e) {
				throw new ApplicationException(e);
			} catch (SQLException sqlException) {
				throw new DatabaseOperationException(sqlException);
			}
		finally {

			try {
				
				
				if (connection != null) {
					connection.close();
					statement.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}
		return res;
	}
	
	
	/**
	 * @param csTOList
	 * @param n
	 * @param custTo
	 * @param registerto
	 * @return ReservationDetailTo
	 * @throws BusinessException
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 * @throws SQLException
	 */
	public ReservationDetailTo customerReserveHotel(String hotel_id,String cust_id,ReservationDetailTo registerto) throws BusinessException, DatabaseOperationException, ApplicationException, SQLException
	{
		ReservationDetailTo registerTO=null;
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		registerTO=registerto;
		System.out.println(registerto.getCheck_out_date());
		try {
			
		      connection = DbUtil.getConnection();
			 
		String sql=QueryConstants.BOOK_HOTEL;
		statement = connection.prepareStatement(sql);
		String customerId=cust_id;
		statement.setString(1,customerId);
		java.util.Date dateUtil=new Date();
		java.sql.Date dateSql=new java.sql.Date(dateUtil.getTime());
		statement.setDate(2,dateSql);
		statement.setString(3,hotel_id);
		
		java.sql.Date check_in_date=new java.sql.Date(registerTO.getCheck_in_date().getTime());
		java.sql.Date check_out_date=new java.sql.Date(registerTO.getCheck_out_date().getTime());
		statement.setDate(4,check_in_date);
		statement.setDate(5,check_out_date);
		statement.setInt(6,registerTO.getNo_of_adults());
		statement.setInt(7,registerTO.getNo_of_children());
		statement.setInt(8,registerTO.getTotal_rooms());
		statement.setString(9,registerTO.getRoom_type());
		statement.setLong(10,registerTO.getTotal_price());
		
		result = statement.executeQuery();
		
		if(result.next()){
			LOG.info("Hotel-Booked");
			String booking_id=bookingId(hotel_id,check_in_date,customerId);
			registerTO.setBooking_id(booking_id);
			
			
			
		}
			}
		catch (ClassNotFoundException e1) {
		
				throw new ApplicationException("Application Exception");
			} catch (IOException e1) {
				LOG.error(e1);
				throw new BusinessException("Business Exception");
			} catch (NumberFormatException e1) {
				
				LOG.error(e1);
				
			}
			catch(SQLException e){
				
				LOG.error(e);
				throw new DatabaseOperationException("Unable to fetch data");
			}
			finally{
				if(result!=null && statement!=null && connection!=null){
				result.close();
				statement.close();
				connection.close();
			}}
           
	 return registerTO;
	}
	
	/**
	 * @param hotel_id
	 * @param check_in_date
	 * @param customer_id
	 * @return s
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public String  bookingId(String hotel_id, java.sql.Date check_in_date,String customer_id) throws DatabaseOperationException, ApplicationException{
		// TODO Auto-generated method stub
		
		ResultSet result1 =null;
		PreparedStatement statement1=null;

		String s="";
		
		Connection connection = null;
		try {
			connection=DbUtil.getConnection();
			LOG.info("Inside booking _id in dao class");
			String sql1=QueryConstants.FIND_ID;
		    statement1 = connection.prepareStatement(sql1);
			statement1.setString(1,customer_id);
		
		statement1.setDate(2,check_in_date);
		statement1.setString(3,hotel_id);
		result1 =statement1.executeQuery();
		while(result1.next()){
		 s=result1.getString("booking_id");
		
		
		}
		}
		catch (SQLException e) { 
			LOG.error(e);		
			throw new DatabaseOperationException("sql Exception caught in booking_id");
		}
		catch(ClassNotFoundException e){
			LOG.error(e);
			throw new ApplicationException("class not found exception in booking_id");
		}
		catch(IOException e){
			LOG.error(e);
			throw new ApplicationException("IO Exception in booking id");
		}
		finally{
			
			try {
				
				if(connection!=null && result1!=null && statement1!=null){
					result1.close();
					statement1.close();
				    connection.close();
				}
			} 
			
			catch (SQLException e) {
				
				LOG.error(e);
				throw new DatabaseOperationException("sql Exception caught in booking_id");
			}
		}
		return s;
		}
		

      
	/**
	 * @param cust_id
	 * @return RegistrationTo
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public Date generateDateofBirth(String cust_id) throws DatabaseOperationException, ApplicationException{
    	  
		Date date = null;
    		  String sql2=QueryConstants.DATE_OF_BIRTH;
    		  java.util.Date date_of_birth=new Date();
    		  RegistrationTo rto=new RegistrationTo();
    	      PreparedStatement statement2 = null;
    	      ResultSet result2 = null ;
    	      Connection connection = null;
		try {
			connection=DbUtil.getConnection();
			
			statement2 = connection.prepareStatement(sql2);
		
		LOG.info("Inside generateDateofBirth ");
    	  statement2.setString(1,cust_id);
    	  result2 = statement2.executeQuery();
    	  if(result2.next()){
    			date=date_of_birth=result2.getDate("date_of_birth");
    			System.out.println(date_of_birth);
    			rto.setDate_of_birth(date_of_birth);
    			
    			}
    	 
		} catch (SQLException e) {
			LOG.error(e);
		
			throw new DatabaseOperationException("Sql Exception in geration of date of birth");
		}
		catch(ClassNotFoundException e){
			LOG.error(e);
			throw new ApplicationException("class not found exception in booking_id");
		}
		catch(IOException e){
			LOG.error(e);
			throw new ApplicationException("IO Exception in booking id");
		}
		
		finally{
		 if(connection!=null){
				
			    try {
			    	result2.close();
			    	statement2.close();
					connection.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new DatabaseOperationException("database operation exception");
				}
		 }
			    
		}
		return date;
      }
	
/**
 * @param customerSearchTO
 * @return List<HotelSearchTO> 
 * @throws BusinessException
 * @throws DatabaseOperationException
 * @throws ApplicationException
 */
// search hotel list
	
      public List<HotelSearchTO> customerSearchHotel(HotelSearchTO customerSearchTO) throws BusinessException, DatabaseOperationException, ApplicationException{
  		
  		Connection connection=null;
  		List<HotelSearchTO> csTOList=new ArrayList<HotelSearchTO>();
  		 HotelSearchTO csTO=null;
  		ResultSet result=null;
  		PreparedStatement statement =null;
  			try {
  				connection = DbUtil.getConnection();
  			 
  		
  		LOG.info("Return list of search Hotel");
  		String sql=QueryConstants.SEARCH_HOTEL;
  		statement = connection.prepareStatement(sql);
  		statement.setString(1,customerSearchTO.getCountry());
  	    statement.setString(2,customerSearchTO.getCity());
  		result = statement.executeQuery();
  			
  			while(result.next()){
  				
  			csTO=new HotelSearchTO();
  			csTO.setHotel_id(result.getString("Hotel_id"));
  			csTO.setHotel_name(result.getString("Hotel_name"));
  			csTO.setDescription(result.getString("Hotel_description"));
  		    csTO.setRate_adult_per_night_AC(result.getInt("rate_Adult_per_night_AC"));
  		    csTOList.add(csTO);
  		    
  			} 
  			System.out.println(csTOList.size());
  		
  		
  			}
  			catch (ClassNotFoundException e1) {
  				
  				LOG.error(e1);
  				throw new ApplicationException("Application Exception");
  			} catch (IOException e1) {
  				LOG.error(e1);
  				throw new BusinessException("Business Exception");
  			} catch (NumberFormatException e1) {
  				LOG.error(e1);
  			
  			}
  			catch(SQLException e){
  				LOG.error(e);
  				throw new DatabaseOperationException("Unable to fetch data");
  			}
  			finally{
  				if(connection!=null){
  		  			try {
						result.close();
					
  		  			statement.close();
  		  				connection.close();
  		  			}
  		  			catch (SQLException e) {
  		  			LOG.error(e);
  		  			throw new DatabaseOperationException("database operation exception");
					}
  		  		}
  			}
  			return csTOList;
  	}
	
	
      
      /**
     * @param reservationDetailTo
     * @param hotel_id
     * @return res
     * @throws ApplicationException
     * @throws DatabaseOperationException
     */
    public boolean check_availibilty(ReservationDetailTo reservationDetailTo,String hotel_id) throws ApplicationException, DatabaseOperationException {
  		PreparedStatement statement = null;
  		Connection connection=null;
  		ResultSet rs=null;
  		boolean res=false;
  		List<RoomAvailabiltyTo> list=new ArrayList<RoomAvailabiltyTo>();
  		try {
  			connection=DbUtil.getConnection();
  			String sql=QueryConstants.ROOM_AVAILIBITY_MATCHING;
  			statement =connection.prepareStatement(sql);
  			statement.setString(1,hotel_id);
  			rs=statement.executeQuery();
  			
  			while(rs.next()){
  				System.out.println("test2");
  				RoomAvailabiltyTo ra=new RoomAvailabiltyTo();
  				ra.setHotel_id(rs.getString("hotel_id"));
  				ra.setAvailable_ac_rooms(rs.getInt("avail_AC_rooms"));
  				ra.setAvailable_non_ac_rooms(rs.getInt("avail_non_AC_rooms"));
  				ra.setOocupied_ac_rooms(rs.getInt("occupied_AC_rooms"));
  				ra.setOocupied_non_ac_rooms(rs.getInt("occupied_non_AC_rooms"));
  				ra.setFrom_date(rs.getDate("from_date"));
  				ra.setTo_date(rs.getDate("to_date"));
  				list.add(ra);
  			}
  			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
  			
  			System.out.println(reservationDetailTo.getCheck_in_date());
  			
  			for(RoomAvailabiltyTo r:list){
  				System.out.println(reservationDetailTo.getRoom_type());
  				if(reservationDetailTo.getRoom_type().equalsIgnoreCase("ac room") && hotel_id.equals(r.getHotel_id())){
  					
  					if(!r.getFrom_date().equals(reservationDetailTo.getCheck_in_date()) && !r.getTo_date().equals(reservationDetailTo.getCheck_out_date()) && r.getAvailable_ac_rooms()>reservationDetailTo.getTotal_rooms()){
  						// insert in room_availibility table and return true;
  						if(r.getAvailable_ac_rooms()>reservationDetailTo.getTotal_rooms()){
  						
  						res=true;
  						
  						}
  					}
  				}
  				else if(reservationDetailTo.getRoom_type().equalsIgnoreCase("non ac") && hotel_id.equals(r.getHotel_id())){
  					if(!r.getFrom_date().equals(reservationDetailTo.getCheck_in_date()) && !r.getTo_date().equals(reservationDetailTo.getCheck_out_date()) && r.getAvailable_ac_rooms()>reservationDetailTo.getTotal_rooms()){
  						// insert in room_availibility table and return true;
  						if(r.getAvailable_non_ac_rooms()>reservationDetailTo.getTotal_rooms()){
  		
  						res=true;
  						
  						}
  					}
  				}
  			}
  			
  		} catch (ClassNotFoundException e) {
  			LOG.error(e);
  			throw new ApplicationException("Application Exception found in room availibilty");
  		} catch (IOException e) {
  			LOG.error(e);
  			throw new ApplicationException("Application Exception found in room availibilty");
  		} catch (SQLException e) {
  			LOG.error(e);
  			throw new DatabaseOperationException("Database operation Exception found in room availibilty");
  			
  		}
  		finally{
  			try {
  				rs.close();
				statement.close();
				
	  			connection.close();
  			}
			 catch (SQLException e) {
				 LOG.error(e);
				throw new DatabaseOperationException("sql exception in room availibilty in hotel dao");
			}
  			
  		}
  		return res;
  	}

      /**
     * @param reservationDetailTo
     * @param hotel_id 
     * @param paymentTo
     * @return res
     * @throws ApplicationException
     * @throws DatabaseOperationException
     */
    public boolean populate_room_availability(ReservationDetailTo reservationDetailTo,
    			String hotel_id,PaymentTo paymentTo) throws ApplicationException, DatabaseOperationException {
    		PreparedStatement statement = null;
    		Connection connection=null;
    		ResultSet rs=null;
    		boolean res=false;
    		List<RoomAvailabiltyTo> list=new ArrayList<RoomAvailabiltyTo>();
    		try {
    			connection=DbUtil.getConnection();
    			String sql=QueryConstants.ROOM_AVAILIBITY_MATCHING;
    			statement =connection.prepareStatement(sql);
    			statement.setString(1,hotel_id);
    			rs=statement.executeQuery();
    			
    			while(rs.next()){
    				
    				RoomAvailabiltyTo ra=new RoomAvailabiltyTo();
    				ra.setHotel_id(rs.getString("hotel_id"));
    				ra.setAvailable_ac_rooms(rs.getInt("avail_AC_rooms"));
    				ra.setAvailable_non_ac_rooms(rs.getInt("avail_non_AC_rooms"));
    				ra.setOocupied_ac_rooms(rs.getInt("occupied_AC_rooms"));
    				ra.setOocupied_non_ac_rooms(rs.getInt("occupied_non_AC_rooms"));
    				ra.setFrom_date(rs.getDate("from_date"));
    				ra.setTo_date(rs.getDate("to_date"));
    				list.add(ra);
    			}
    			
    			for(RoomAvailabiltyTo r:list){
    				if(reservationDetailTo.getRoom_type().equalsIgnoreCase("ac") && hotel_id.equals(r.getHotel_id())){
    					if(!r.getFrom_date().equals(reservationDetailTo.getCheck_in_date()) && !r.getTo_date().equals(reservationDetailTo.getCheck_out_date()) && r.getAvailable_ac_rooms()>reservationDetailTo.getTotal_rooms()){
    						
    						if(r.getAvailable_ac_rooms()>reservationDetailTo.getTotal_rooms()){
    						sql=QueryConstants.INSERT_ROOM_AVAILABILITY;
    						System.out.println("ready to insert");
    						statement=connection.prepareStatement(sql);
    						statement.setString(1,r.getRoom_id());
    						statement.setString(2,hotel_id);
    						statement.setInt(3,r.getAvailable_non_ac_rooms());
    						statement.setInt(4,r.getOocupied_non_ac_rooms());
    						statement.setInt(5,r.getAvailable_ac_rooms()-reservationDetailTo.getTotal_rooms());
    						statement.setInt(6,r.getOocupied_ac_rooms()+reservationDetailTo.getTotal_rooms());
    						
    						statement.setString(7,paymentTo.getCard_type());
    						
    						statement.setString(8,paymentTo.getName_on_card());
    						
    						statement.setDate(9,(java.sql.Date) r.getFrom_date());
    						
    						statement.setDate(10,(java.sql.Date) r.getTo_date());
    						
    						int no=statement.executeUpdate();
    						if(no>=0){
    						res=true;
    						
    						}
    					}
    					}
    				}
    				else if(reservationDetailTo.getRoom_type().equalsIgnoreCase("nonac") && hotel_id.equals(r.getHotel_id())){
    					if(!r.getFrom_date().equals(reservationDetailTo.getCheck_in_date()) && !r.getTo_date().equals(reservationDetailTo.getCheck_out_date()) && r.getAvailable_ac_rooms()>reservationDetailTo.getTotal_rooms()){
    						
    						if(r.getAvailable_non_ac_rooms()>reservationDetailTo.getTotal_rooms()){
    						sql=QueryConstants.INSERT_ROOM_AVAILABILITY;
    						statement=connection.prepareStatement(sql);
    						statement.setString(1,r.getRoom_id());
    						statement.setString(2,hotel_id);
    						statement.setInt(3,r.getAvailable_non_ac_rooms()-reservationDetailTo.getTotal_rooms());
    						statement.setInt(4,r.getOocupied_non_ac_rooms()+reservationDetailTo.getTotal_rooms());
    						statement.setInt(5,r.getAvailable_ac_rooms());
    						statement.setInt(6,r.getOocupied_ac_rooms());
    						
    						statement.setString(7,paymentTo.getCard_type());
    						
    						statement.setString(8,paymentTo.getName_on_card());
    						
    						statement.setDate(9,(java.sql.Date) r.getFrom_date());
    						
    						statement.setDate(10,(java.sql.Date) r.getTo_date());
    						int no=statement.executeUpdate();
    						if(no>=0){
    						res=true;
    						}
    					}
    					}
    				}
    			}
    			
    		} catch (ClassNotFoundException e) {
    			LOG.error(e);
    			throw new ApplicationException("Application Exception found in room availibilty");
    		} catch (IOException e) {
    			LOG.error(e);
    			throw new ApplicationException("Application Exception found in room availibilty");
    		} catch (SQLException e) {
    			LOG.error(e);
    			throw new DatabaseOperationException("Database operation Exception found in room availibilty");
    			
    		}
    		finally{
    			try {
    				rs.close();
  				statement.close();
  				
  	  			connection.close();
    			}
  			 catch (SQLException e) {
  				LOG.error(e);
  				throw new DatabaseOperationException("sql exception in room availibilty in hotel dao");
  			}
    			
    		}
    		return res;
    	}
    
    public HotelTo findHotel(HotelTo hotelTo) throws ApplicationException, DatabaseOperationException{
	    PreparedStatement statement = null;
		Connection connection=null;
		ResultSet rs=null;
		HotelTo hotel=null;
		try {
			connection=DbUtil.getConnection();
			
			String sql=QueryConstants.GET_HOTEL;
			statement =connection.prepareStatement(sql);
			statement.setString(1, hotelTo.getHotel_id());
			rs=statement.executeQuery();
			while(rs.next()){
				hotel=new HotelTo();
				hotel.setHotel_id(rs.getString("HOTEL_ID"));
				hotel.setHotel_name(rs.getString("HOTEL_NAME"));
				hotel.setHotel_description(rs.getString("HOTEL_DESCRIPTION"));
				hotel.setCountry(rs.getString("COUNTRY"));
				hotel.setCity(rs.getString("CITY"));
				hotel.setNo_of_ac_rooms(rs.getInt("NO_OF_AC_ROOMS"));
				hotel.setNo_of_non_ac_rooms(rs.getInt("NO_OF_NON_AC_ROOMS"));
				hotel.setRate_child_per_night_ac(rs.getInt("RATE_CHILD_PER_NIGHT_AC"));
				hotel.setRate_child_per_night_non_ac(rs.getInt("RATE_CHILD_PER_NIGHT_NON_AC"));
				hotel.setRate_adult_per_night_ac(rs.getInt("RATE_ADULT_PER_NIGHT_AC"));
				hotel.setRate_adult_per_night_non_ac(rs.getInt("RATE_ADULT_PER_NIGHT_NON_AC"));
			}
  
  } catch (ClassNotFoundException e) {
	  LOG.error(e);
		throw new ApplicationException("Application Exception found in room availibilty");
	} catch (IOException e) {
		LOG.error(e);
		throw new ApplicationException("Application Exception found in room availibilty");
	} catch (SQLException e) {
		LOG.error(e);
		throw new DatabaseOperationException("Database operation Exception found in room availibilty");
		
	}
	finally{
		try {
			rs.close();
		statement.close();
		
			connection.close();
		}
	 catch (SQLException e) {
		 LOG.error(e);
		throw new DatabaseOperationException("sql exception in room availibilty in hotel dao");
	}


}
		
		return hotel;
  }

	public boolean deleteBooking(String booking_id) throws ApplicationException, DatabaseOperationException {
	
		PreparedStatement statement=null;
		Connection connection = null;
		boolean res=false;
		try{
		connection=DbUtil.getConnection();
		System.out.println("Connected");
		String sql=QueryConstants.DELETE_BOOKING;
		statement=connection.prepareStatement(sql);
		System.out.println("Connection set");
		statement.setString(1,booking_id);
		int no=statement.executeUpdate();
		if(no>=1)
		{
		res=true;
		
		}
		statement.close();
		sql=QueryConstants.DELETE_BOOKING_PAYMENTDETAILS;
		statement=connection.prepareStatement(sql);
		System.out.println("Connection set");
		statement.setString(1,booking_id);
		int no2=statement.executeUpdate();
		if(no2>=1)
		{
		res=true;
		
		}
		statement.close();
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
		if (connection != null) {
		connection.close();
		}
		} catch (SQLException sqlException) {
			LOG.error(sqlException);
		new DatabaseOperationException(sqlException);
		}
		}
		return res;

		
		
		
	}

}
