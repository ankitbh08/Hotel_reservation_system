package com.hrs.to;

import java.util.Date;

public class RoomAvailabiltyTo {
private String room_id;
private String hotel_id;
private int available_ac_rooms;
private int available_non_ac_rooms;
private int oocupied_non_ac_rooms;
private int oocupied_ac_rooms;
private Date from_date;
private Date to_date;
public RoomAvailabiltyTo(String room_id, String hotel_id, int available_ac_rooms,
		int available_non_ac_rooms, int oocupied_non_ac_rooms,
		int oocupied_ac_rooms, Date from_date, Date to_date) {
	super();
	this.room_id = room_id;
	this.hotel_id = hotel_id;
	this.available_ac_rooms = available_ac_rooms;
	this.available_non_ac_rooms = available_non_ac_rooms;
	this.oocupied_non_ac_rooms = oocupied_non_ac_rooms;
	this.oocupied_ac_rooms = oocupied_ac_rooms;
	this.from_date = from_date;
	this.to_date = to_date;
}
public RoomAvailabiltyTo(){}
public String getRoom_id() {
	return room_id;
}
public void setRoom_id(String room_id) {
	this.room_id = room_id;
}
public String getHotel_id() {
	return hotel_id;
}
public void setHotel_id(String hotel_id) {
	this.hotel_id = hotel_id;
}
public int getAvailable_ac_rooms() {
	return available_ac_rooms;
}
public void setAvailable_ac_rooms(int available_ac_rooms) {
	this.available_ac_rooms = available_ac_rooms;
}
public int getAvailable_non_ac_rooms() {
	return available_non_ac_rooms;
}
public void setAvailable_non_ac_rooms(int available_non_ac_rooms) {
	this.available_non_ac_rooms = available_non_ac_rooms;
}
public int getOocupied_non_ac_rooms() {
	return oocupied_non_ac_rooms;
}
public void setOocupied_non_ac_rooms(int oocupied_non_ac_rooms) {
	this.oocupied_non_ac_rooms = oocupied_non_ac_rooms;
}
public int getOocupied_ac_rooms() {
	return oocupied_ac_rooms;
}
public void setOocupied_ac_rooms(int oocupied_ac_rooms) {
	this.oocupied_ac_rooms = oocupied_ac_rooms;
}
public Date getFrom_date() {
	return from_date;
}
public void setFrom_date(Date from_date) {
	this.from_date = from_date;
}
public Date getTo_date() {
	return to_date;
}
public void setTo_date(Date to_date) {
	this.to_date = to_date;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + available_ac_rooms;
	result = prime * result + available_non_ac_rooms;
	result = prime * result + ((from_date == null) ? 0 : from_date.hashCode());
	result = prime * result + ((hotel_id == null) ? 0 : hotel_id.hashCode());
	result = prime * result + oocupied_ac_rooms;
	result = prime * result + oocupied_non_ac_rooms;
	result = prime * result + ((room_id == null) ? 0 : room_id.hashCode());
	result = prime * result + ((to_date == null) ? 0 : to_date.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	RoomAvailabiltyTo other = (RoomAvailabiltyTo) obj;
	if (available_ac_rooms != other.available_ac_rooms)
		return false;
	if (available_non_ac_rooms != other.available_non_ac_rooms)
		return false;
	if (from_date == null) {
		if (other.from_date != null)
			return false;
	} else if (!from_date.equals(other.from_date))
		return false;
	if (hotel_id == null) {
		if (other.hotel_id != null)
			return false;
	} else if (!hotel_id.equals(other.hotel_id))
		return false;
	if (oocupied_ac_rooms != other.oocupied_ac_rooms)
		return false;
	if (oocupied_non_ac_rooms != other.oocupied_non_ac_rooms)
		return false;
	if (room_id == null) {
		if (other.room_id != null)
			return false;
	} else if (!room_id.equals(other.room_id))
		return false;
	if (to_date == null) {
		if (other.to_date != null)
			return false;
	} else if (!to_date.equals(other.to_date))
		return false;
	return true;
}
@Override
public String toString() {
	return "RoomAvailabilty [room_id=" + room_id + ", hotel_id=" + hotel_id
			+ ", available_ac_rooms=" + available_ac_rooms
			+ ", available_non_ac_rooms=" + available_non_ac_rooms
			+ ", oocupied_non_ac_rooms=" + oocupied_non_ac_rooms
			+ ", oocupied_ac_rooms=" + oocupied_ac_rooms + ", from_date="
			+ from_date + ", to_date=" + to_date + "]";
}


}
