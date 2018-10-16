package com.hrs.to;

import java.time.LocalDate;
import java.util.Date;

public class RegistrationTo {
	private String customer_id;
	private String customer_name;
	private String password;
	private String cnfm_password;
	private Date date_of_birth;
	private String email;
	private String phone;
	private String country;
	private String city;
	private String pin_code;
	
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCnfm_password() {
		return cnfm_password;
	}
	public void setCnfm_password(String cnfm_password) {
		this.cnfm_password = cnfm_password;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public RegistrationTo(String customer_name, String password, String cnfm_password,
			Date date_of_birth, String email, String phone, String country,
			String city, String pin_code) {
		super();
		this.customer_name = customer_name;
		this.password = password;
		this.cnfm_password = cnfm_password;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.pin_code = pin_code;
	}

	
	public RegistrationTo() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((cnfm_password == null) ? 0 : cnfm_password.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((customer_name == null) ? 0 : customer_name.hashCode());
		result = prime * result
				+ ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((pin_code == null) ? 0 : pin_code.hashCode());
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
		RegistrationTo other = (RegistrationTo) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cnfm_password == null) {
			if (other.cnfm_password != null)
				return false;
		} else if (!cnfm_password.equals(other.cnfm_password))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customer_name == null) {
			if (other.customer_name != null)
				return false;
		} else if (!customer_name.equals(other.customer_name))
			return false;
		if (date_of_birth == null) {
			if (other.date_of_birth != null)
				return false;
		} else if (!date_of_birth.equals(other.date_of_birth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (pin_code == null) {
			if (other.pin_code != null)
				return false;
		} else if (!pin_code.equals(other.pin_code))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserTo [customer_name=" + customer_name + ", password="
				+ password + ", cnfm_password=" + cnfm_password
				+ ", date_of_birth=" + date_of_birth + ", email=" + email
				+ ", phone=" + phone + ", country=" + country + ", city="
				+ city + ", pin_code=" + pin_code + "]";
	}
	
	

}
