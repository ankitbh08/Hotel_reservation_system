package com.hrs.to;

import java.util.Date;

public class ReservationDetailTo {
	
private String booking_id;
private Date check_in_date;
private Date check_out_date;
private int no_of_adults;
private int no_of_children;
private int total_rooms;
private String room_type;
private long total_price;

public ReservationDetailTo(){}

public ReservationDetailTo(Date check_in_date, Date check_out_date,
		int no_of_adults, int no_of_children, int total_rooms,
		String room_type, int total_price) {
	super();
	this.check_in_date = check_in_date;
	this.check_out_date = check_out_date;
	this.no_of_adults = no_of_adults;
	this.no_of_children = no_of_children;
	this.total_rooms = total_rooms;
	this.room_type = room_type;
	this.total_price = total_price;
}
public String getBooking_id() {
	return booking_id;
}

public void setBooking_id(String booking_id) {
	this.booking_id = booking_id;
}
public Date getCheck_in_date() {
	return check_in_date;
}

public void setCheck_in_date(Date check_in_date) {
	this.check_in_date = check_in_date;
}

public Date getCheck_out_date() {
	return check_out_date;
}

public void setCheck_out_date(Date check_out_date) {
	this.check_out_date = check_out_date;
}

public int getNo_of_adults() {
	return no_of_adults;
}

public void setNo_of_adults(int no_of_adults) {
	this.no_of_adults = no_of_adults;
}

public int getNo_of_children() {
	return no_of_children;
}

public void setNo_of_children(int no_of_children) {
	this.no_of_children = no_of_children;
}

public int getTotal_rooms() {
	return total_rooms;
}

public void setTotal_rooms(int total_rooms) {
	this.total_rooms = total_rooms;
}

public String getRoom_type() {
	return room_type;
}

public void setRoom_type(String room_type) {
	this.room_type = room_type;
}

public long getTotal_price() {
	return total_price;
}

public void setTotal_price(long total_price) {
	this.total_price = total_price;
}

}
