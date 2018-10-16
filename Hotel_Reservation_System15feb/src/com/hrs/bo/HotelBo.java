package com.hrs.bo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.hrs.dao.HotelDao;
import com.hrs.exceptions.ApplicationException;
import com.hrs.exceptions.BusinessException;
import com.hrs.exceptions.DatabaseOperationException;
import com.hrs.to.HotelSearchTO;
import com.hrs.to.HotelTo;
import com.hrs.to.PaymentTo;
import com.hrs.to.RegistrationTo;
import com.hrs.to.ReservationDetailTo;
import com.hrs.to.UserTo;



/**
 * @author 
 *
 */
public class HotelBo {
	final Logger LOG = Logger.getLogger("HotelBo");
	HotelDao hoteldao=null;
	/**
	 * 
	 */
	public HotelBo(){
		hoteldao=new HotelDao();
	}
	/**
	 * @param hotelTo
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public boolean addHotel(HotelTo hotelTo) throws DatabaseOperationException, ApplicationException
	{
		return hoteldao.addHotel(hotelTo);
	}
	

	
	
	/**
	 * @param hotelTo
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public boolean editHotel(HotelTo hotelTo) throws DatabaseOperationException, ApplicationException
	{
		return hoteldao.editHotel(hotelTo);
	}
	
	
	/**
	 * @param hotelTo
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public boolean deleteHotel(HotelTo hotelTo) throws DatabaseOperationException, ApplicationException
	{
		return hoteldao.deleteHotel(hotelTo);
	}
	/**
	 * @param csTOList
	 * @param n
	 * @param custTo
	 * @param registerTo
	 * @return ReservationDetailTo
	 * @throws DatabaseOperationException
	 */
	public ReservationDetailTo reserveHotel(String hotel_id,String cust_id,ReservationDetailTo registerTo) throws DatabaseOperationException {
		ReservationDetailTo res = null;
		
			try {
				res= hoteldao.customerReserveHotel(hotel_id, cust_id, registerTo);
				
			} catch (SQLException e) {
				LOG.error(e);
				// TODO Auto-generated catch block
				throw new DatabaseOperationException("SQl Exception in BO");
			}
		 catch (BusinessException e) {				
			LOG.error(e);
			
		} catch (DatabaseOperationException e) {
			LOG.error(e);
		} catch (ApplicationException e) {
			LOG.error(e);
		}
		return res;
	}

	/**
	 * @param room_type
	 * @param no_of_adults
	 * @param no_of_children
	 * @param no_of_rooms
	 * @param hotel
	 * @param userTo
	 * @param cust_id
	 * @return price
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public long pricecalculator(String room_type, int no_of_adults,
			int no_of_children, int no_of_rooms,HotelSearchTO hotel,RegistrationTo userTo,String cust_id) throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		long price = 0;
		
		if(room_type.equalsIgnoreCase("ac room")){
			price=((hotel.getRate_adult_per_night_AC()*no_of_adults)+(hotel.getRate_child_per_night_AC()*no_of_children))*no_of_rooms;
			if(ageCalculator(cust_id)>60){
				price=(price-((price*5)/100));
			}
		}
		else if(room_type.equalsIgnoreCase("non ac")){
			System.out.println("inside pricecalc"+hotel.getRate_adult_per_nigt_NON_AC());
			price=((hotel.getRate_adult_per_night_AC()*no_of_adults)+(hotel.getRate_child_per_night_AC()*no_of_children))*no_of_rooms;
			if(ageCalculator(cust_id)>60){
				price=(price-((price*5)/100));
			}
		
		}
		return price;
	}


	/**
	 * @param userTo
	 * @return age
	 * @throws ApplicationException 
	 * @throws DatabaseOperationException 
	 */
	public int ageCalculator(String cust_id) throws DatabaseOperationException, ApplicationException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		Date date=hoteldao.generateDateofBirth(cust_id);
		String d=sdf.format(date);
		String s[]=d.split("-");
		LocalDate date_of_birth = LocalDate.of(Integer.parseInt(s[2]),Integer.parseInt(s[1]),Integer.parseInt(s[0]));
		LocalDate presentDate=LocalDate.now();
		Period period=Period.between(presentDate, date_of_birth);
		int age=period.getYears();
		return age;
	}
	
	/**
	 * @param customerSearchTO
	 * @return List<HotelSearchTO>
	 * @throws ApplicationException
	 * @throws DatabaseOperationException
	 * @throws BusinessException
	 */
	public List<HotelSearchTO> searchHotel(HotelSearchTO customerSearchTO) throws ApplicationException, DatabaseOperationException, BusinessException{
		try {
			return hoteldao.customerSearchHotel(customerSearchTO);
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("Business Exception");
		}
		catch (DatabaseOperationException e) {
			// TODO Auto-generated catch block
			throw new DatabaseOperationException("Unable to find data");
		} 
	}
	
	/**
	 * @param reservationDetailTo
	 * @param hotel_id
	 * @return  hoteldao.check_availibilty(reservationDetailTo,hotel_id)
	 * @throws ApplicationException
	 * @throws DatabaseOperationException
	 */
	public boolean check_availibilty(ReservationDetailTo reservationDetailTo,String hotel_id) throws ApplicationException, DatabaseOperationException {
		// TODO Auto-generated method stub
		return hoteldao.check_availibilty(reservationDetailTo,hotel_id);
	}
	/**
	 * @param hotel_id
	 * @param check_in_date
	 * @param customer_id
	 * @return hoteldao.bookingId(hotel_id, check_in_date, customer_id)
	 * @throws DatabaseOperationException
	 * @throws ApplicationException
	 */
	public String  bookingId(String hotel_id, java.sql.Date check_in_date,String customer_id) throws DatabaseOperationException, ApplicationException{
		return hoteldao.bookingId(hotel_id, check_in_date, customer_id);
	}
	  /**
	 * @param reservationDetailTo
	 * @param hotel_id 
	 * @param paymentTo
	 * @return true/false
	 * @throws ApplicationException
	 * @throws DatabaseOperationException
	 */
	public boolean populate_room_availability(ReservationDetailTo reservationDetailTo, String hotel_id,PaymentTo paymentTo) throws ApplicationException, DatabaseOperationException{
		  return hoteldao.populate_room_availability(reservationDetailTo, hotel_id, paymentTo);
	  }
	 public HotelTo findHotel(HotelTo hotelTo) throws ApplicationException, DatabaseOperationException{
		  return hoteldao.findHotel(hotelTo);
	  }
	 
	 
	 public boolean deleteBooking(String booking_id) throws DatabaseOperationException, ApplicationException
	 {
	 return hoteldao.deleteBooking(booking_id);
	 }


	 
	 
	 
}
