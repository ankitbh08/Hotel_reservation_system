package com.hrs.to;

public class HotelTo {
private String hotel_id;
private  String hotel_name;
private String hotel_description;
private String country;
private String city;
private int no_of_ac_rooms;
private int no_of_non_ac_rooms;
private int rate_child_per_night_ac;
private int rate_child_per_night_non_ac;
private int rate_adult_per_night_ac;
private int rate_adult_per_night_non_ac;
public String getHotel_id() {
	return hotel_id;
}
public HotelTo(String hotel_id, String hotel_name, String hotel_description,
		String country, String city, int no_of_ac_rooms,
		int no_of_non_ac_rooms, int rate_child_per_night_ac,
		int rate_child_per_night_non_ac, int rate_adult_per_night_ac,
		int rate_adult_per_night_non_ac) {
	super();
	this.hotel_id = hotel_id;
	this.hotel_name = hotel_name;
	this.hotel_description = hotel_description;
	this.country = country;
	this.city = city;
	this.no_of_ac_rooms = no_of_ac_rooms;
	this.no_of_non_ac_rooms = no_of_non_ac_rooms;
	this.rate_child_per_night_ac = rate_child_per_night_ac;
	this.rate_child_per_night_non_ac = rate_child_per_night_non_ac;
	this.rate_adult_per_night_ac = rate_adult_per_night_ac;
	this.rate_adult_per_night_non_ac = rate_adult_per_night_non_ac;
}
public String getHotel_name() {
	return hotel_name;
}
public void setHotel_name(String hotel_name) {
	this.hotel_name = hotel_name;
}
public String getHotel_description() {
	return hotel_description;
}
public void setHotel_description(String hotel_description) {
	this.hotel_description = hotel_description;
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
public int getNo_of_ac_rooms() {
	return no_of_ac_rooms;
}
public void setNo_of_ac_rooms(int no_of_ac_rooms) {
	this.no_of_ac_rooms = no_of_ac_rooms;
}
public int getNo_of_non_ac_rooms() {
	return no_of_non_ac_rooms;
}
public void setNo_of_non_ac_rooms(int no_of_non_ac_rooms) {
	this.no_of_non_ac_rooms = no_of_non_ac_rooms;
}
public int getRate_child_per_night_ac() {
	return rate_child_per_night_ac;
}
public void setRate_child_per_night_ac(int rate_child_per_night_ac) {
	this.rate_child_per_night_ac = rate_child_per_night_ac;
}
public int getRate_child_per_night_non_ac() {
	return rate_child_per_night_non_ac;
}
public void setRate_child_per_night_non_ac(int rate_child_per_night_non_ac) {
	this.rate_child_per_night_non_ac = rate_child_per_night_non_ac;
}
public int getRate_adult_per_night_ac() {
	return rate_adult_per_night_ac;
}
public void setRate_adult_per_night_ac(int rate_adult_per_night_ac) {
	this.rate_adult_per_night_ac = rate_adult_per_night_ac;
}
public int getRate_adult_per_night_non_ac() {
	return rate_adult_per_night_non_ac;
}
public void setRate_adult_per_night_non_ac(int rate_adult_per_night_non_ac) {
	this.rate_adult_per_night_non_ac = rate_adult_per_night_non_ac;
}
public void setHotel_id(String hotel_id) {
	this.hotel_id = hotel_id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result
			+ ((hotel_description == null) ? 0 : hotel_description.hashCode());
	result = prime * result + ((hotel_id == null) ? 0 : hotel_id.hashCode());
	result = prime * result
			+ ((hotel_name == null) ? 0 : hotel_name.hashCode());
	result = prime * result + no_of_ac_rooms;
	result = prime * result + no_of_non_ac_rooms;
	result = prime * result + rate_adult_per_night_ac;
	result = prime * result + rate_adult_per_night_non_ac;
	result = prime * result + rate_child_per_night_ac;
	result = prime * result + rate_child_per_night_non_ac;
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
	HotelTo other = (HotelTo) obj;
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
	if (hotel_description == null) {
		if (other.hotel_description != null)
			return false;
	} else if (!hotel_description.equals(other.hotel_description))
		return false;
	if (hotel_id == null) {
		if (other.hotel_id != null)
			return false;
	} else if (!hotel_id.equals(other.hotel_id))
		return false;
	if (hotel_name == null) {
		if (other.hotel_name != null)
			return false;
	} else if (!hotel_name.equals(other.hotel_name))
		return false;
	if (no_of_ac_rooms != other.no_of_ac_rooms)
		return false;
	if (no_of_non_ac_rooms != other.no_of_non_ac_rooms)
		return false;
	if (rate_adult_per_night_ac != other.rate_adult_per_night_ac)
		return false;
	if (rate_adult_per_night_non_ac != other.rate_adult_per_night_non_ac)
		return false;
	if (rate_child_per_night_ac != other.rate_child_per_night_ac)
		return false;
	if (rate_child_per_night_non_ac != other.rate_child_per_night_non_ac)
		return false;
	return true;
}
public HotelTo() {
	super();
}


}