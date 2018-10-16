package com.hrs.to;

public class CustomerTOLogin {
private String username;
private String password;
private String mobileNumber;
public CustomerTOLogin(String username, String password, String mobileNumber) {
	super();
	this.username = username;
	this.password = password;
	this.mobileNumber = mobileNumber;
}
public CustomerTOLogin(){}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String toString() {
	return "CustomerToLogin [username=" + username + ", password=" + password
			+ ", mobileNumber=" + mobileNumber + "]";
}
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CustomerTOLogin other = (CustomerTOLogin) obj;
	if (mobileNumber == null) {
		if (other.mobileNumber != null)
			return false;
	} else if (!mobileNumber.equals(other.mobileNumber))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}


}
