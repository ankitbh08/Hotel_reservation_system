package com.hrs.to;

import java.util.Date;

public class HotelSearchTO {
private String hotel_id;
private String hotel_name;
private String country;
private String description;
private int rate_adult_per_night_AC;
private int rate_adult_per_nigt_NON_AC;
private int rate_child_per_night_AC;
private int rate_child_per_nigt_NON_AC;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}



public long getRate_adult_per_night_AC() {
	return rate_adult_per_night_AC;
}
public void setRate_adult_per_night_AC(int rate_adult_per_night_AC) {
	this.rate_adult_per_night_AC = rate_adult_per_night_AC;
}



public long getRate_adult_per_nigt_NON_AC() {
	return rate_adult_per_nigt_NON_AC;
}
public void setRate_adult_per_nigt_NON_AC(int rate_adult_per_nigt_NON_AC) {
	this.rate_adult_per_nigt_NON_AC = rate_adult_per_nigt_NON_AC;
}
public long getRate_child_per_night_AC() {
	return rate_child_per_night_AC;
}
public void setRate_child_per_night_AC(int rate_child_per_night_AC) {
	this.rate_child_per_night_AC = rate_child_per_night_AC;
}
public long getRate_child_per_nigt_NON_AC() {
	return rate_child_per_nigt_NON_AC;
}
public void setRate_child_per_nigt_NON_AC(int rate_child_per_nigt_NON_AC) {
	this.rate_child_per_nigt_NON_AC = rate_child_per_nigt_NON_AC;
}

public String getHotel_id() {
	return hotel_id;
}
public void setHotel_id(String hotel_id) {
	this.hotel_id = hotel_id;
}

private String city;
private Date check_in;
private Date check_out;
private String room_type;
private int no_of_rooms;
private int no_of_adults;
private int no_of_child;
public HotelSearchTO(String hotel_name, String country, String city,
		Date check_in, Date check_out, String room_type, int no_of_rooms,
		int no_of_adults, int no_of_child) {
	super();
	this.hotel_name = hotel_name;
	this.country = country;
	this.city = city;
	this.check_in = check_in;
	this.check_out = check_out;
	this.room_type = room_type;
	this.no_of_rooms = no_of_rooms;
	this.no_of_adults = no_of_adults;
	this.no_of_child = no_of_child;
}
public HotelSearchTO(){
	
}
public String getHotel_name() {
	return hotel_name;
}
public void setHotel_name(String hotel_name) {
	this.hotel_name = hotel_name;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Date getCheck_in() {
	return check_in;
}
public void setCheck_in(Date check_in) {
	this.check_in = check_in;
}
public Date getCheck_out() {
	return check_out;
}
public void setCheck_out(Date check_out) {
	this.check_out = check_out;
}
public String getRoom_type() {
	return room_type;
}
public void setRoom_type(String room_type) {
	this.room_type = room_type;
}
public int getNo_of_rooms() {
	return no_of_rooms;
}
public void setNo_of_rooms(int no_of_rooms) {
	this.no_of_rooms = no_of_rooms;
}
public int getNo_of_adults() {
	return no_of_adults;
}
public void setNo_of_adults(int no_of_adults) {
	this.no_of_adults = no_of_adults;
}
public int getNo_of_child() {
	return no_of_child;
}
public void setNo_of_child(int no_of_child) {
	this.no_of_child = no_of_child;
}
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((check_in == null) ? 0 : check_in.hashCode());
	result = prime * result + ((check_out == null) ? 0 : check_out.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result
			+ ((hotel_name == null) ? 0 : hotel_name.hashCode());
	result = prime * result + no_of_adults;
	result = prime * result + no_of_child;
	result = prime * result + no_of_rooms;
	result = prime * result + ((room_type == null) ? 0 : room_type.hashCode());
	return result;
}
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	HotelSearchTO other = (HotelSearchTO) obj;
	if (check_in == null) {
		if (other.check_in != null)
			return false;
	} else if (!check_in.equals(other.check_in))
		return false;
	if (check_out == null) {
		if (other.check_out != null)
			return false;
	} else if (!check_out.equals(other.check_out))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (country == null) {
		if (other.country != null)
			return false;
	} else if (!country.equals(other.country))
		return false;
	if (hotel_name == null) {
		if (other.hotel_name != null)
			return false;
	} else if (!hotel_name.equals(other.hotel_name))
		return false;
	if (no_of_adults != other.no_of_adults)
		return false;
	if (no_of_child != other.no_of_child)
		return false;
	if (no_of_rooms != other.no_of_rooms)
		return false;
	if (room_type == null) {
		if (other.room_type != null)
			return false;
	} else if (!room_type.equals(other.room_type))
		return false;
	return true;
}
public String toString() {
	return "\nHotel Name:"+ hotel_name + "\nDescription:"
			+ description + "\nrate_adult_per_night_AC="
			+ rate_adult_per_night_AC;
}


}
