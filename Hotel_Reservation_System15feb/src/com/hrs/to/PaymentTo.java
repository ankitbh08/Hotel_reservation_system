package com.hrs.to;

public class PaymentTo {
private String payment_id;
private String booking_id;
private String customer_id;
private String card_no;
private String card_type;
private String name_on_card;
private String expiry_date;
private String cvv;
private String account_no;
private String pin;
private String payment_date;
private String bank_Name;
public PaymentTo(){
	
}
public PaymentTo(String payment_id, String booking_id, String customer_id,
		String card_no, String card_type, String name_on_card,
		String expiry_date, String cvv, String account_no, String pin,
		String payment_date, String bank_Name) {
	super();
	this.payment_id = payment_id;
	this.booking_id = booking_id;
	this.customer_id = customer_id;
	this.card_no = card_no;
	this.card_type = card_type;
	this.name_on_card = name_on_card;
	this.expiry_date = expiry_date;
	this.cvv = cvv;
	this.account_no = account_no;
	this.pin = pin;
	this.payment_date = payment_date;
	this.bank_Name = bank_Name;
}
public String getPayment_id() {
	return payment_id;
}
public void setPayment_id(String payment_id) {
	this.payment_id = payment_id;
}
public String getBooking_id() {
	return booking_id;
}
public void setBooking_id(String booking_id) {
	this.booking_id = booking_id;
}
public String getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}
public String getCard_no() {
	return card_no;
}
public void setCard_no(String card_no) {
	this.card_no = card_no;
}
public String getCard_type() {
	return card_type;
}
public void setCard_type(String card_type) {
	this.card_type = card_type;
}
public String getName_on_card() {
	return name_on_card;
}
public void setName_on_card(String name_on_card) {
	this.name_on_card = name_on_card;
}
public String getExpiry_date() {
	return expiry_date;
}
public void setExpiry_date(String expiry_date) {
	this.expiry_date = expiry_date;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getAccount_no() {
	return account_no;
}
public void setAccount_no(String account_no) {
	this.account_no = account_no;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}
public String getPayment_date() {
	return payment_date;
}
public void setPayment_date(String payment_date) {
	this.payment_date = payment_date;
}
public String getBank_Name() {
	return bank_Name;
}
public void setBank_Name(String bank_Name) {
	this.bank_Name = bank_Name;
}
@Override
public String toString() {
	return "PaymentTo [payment_id=" + payment_id + ", booking_id=" + booking_id
			+ ", customer_id=" + customer_id + ", card_no=" + card_no
			+ ", card_type=" + card_type + ", name_on_card=" + name_on_card
			+ ", expiry_date=" + expiry_date + ", cvv=" + cvv + ", account_no="
			+ account_no + ", pin=" + pin + ", payment_date=" + payment_date
			+ ", bank_Name=" + bank_Name + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((account_no == null) ? 0 : account_no.hashCode());
	result = prime * result + ((bank_Name == null) ? 0 : bank_Name.hashCode());
	result = prime * result
			+ ((booking_id == null) ? 0 : booking_id.hashCode());
	result = prime * result + ((card_no == null) ? 0 : card_no.hashCode());
	result = prime * result + ((card_type == null) ? 0 : card_type.hashCode());
	result = prime * result
			+ ((customer_id == null) ? 0 : customer_id.hashCode());
	result = prime * result + ((cvv == null) ? 0 : cvv.hashCode());
	result = prime * result
			+ ((expiry_date == null) ? 0 : expiry_date.hashCode());
	result = prime * result
			+ ((name_on_card == null) ? 0 : name_on_card.hashCode());
	result = prime * result
			+ ((payment_date == null) ? 0 : payment_date.hashCode());
	result = prime * result
			+ ((payment_id == null) ? 0 : payment_id.hashCode());
	result = prime * result + ((pin == null) ? 0 : pin.hashCode());
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
	PaymentTo other = (PaymentTo) obj;
	if (account_no == null) {
		if (other.account_no != null)
			return false;
	} else if (!account_no.equals(other.account_no))
		return false;
	if (bank_Name == null) {
		if (other.bank_Name != null)
			return false;
	} else if (!bank_Name.equals(other.bank_Name))
		return false;
	if (booking_id == null) {
		if (other.booking_id != null)
			return false;
	} else if (!booking_id.equals(other.booking_id))
		return false;
	if (card_no == null) {
		if (other.card_no != null)
			return false;
	} else if (!card_no.equals(other.card_no))
		return false;
	if (card_type == null) {
		if (other.card_type != null)
			return false;
	} else if (!card_type.equals(other.card_type))
		return false;
	if (customer_id == null) {
		if (other.customer_id != null)
			return false;
	} else if (!customer_id.equals(other.customer_id))
		return false;
	if (cvv == null) {
		if (other.cvv != null)
			return false;
	} else if (!cvv.equals(other.cvv))
		return false;
	if (expiry_date == null) {
		if (other.expiry_date != null)
			return false;
	} else if (!expiry_date.equals(other.expiry_date))
		return false;
	if (name_on_card == null) {
		if (other.name_on_card != null)
			return false;
	} else if (!name_on_card.equals(other.name_on_card))
		return false;
	if (payment_date == null) {
		if (other.payment_date != null)
			return false;
	} else if (!payment_date.equals(other.payment_date))
		return false;
	if (payment_id == null) {
		if (other.payment_id != null)
			return false;
	} else if (!payment_id.equals(other.payment_id))
		return false;
	if (pin == null) {
		if (other.pin != null)
			return false;
	} else if (!pin.equals(other.pin))
		return false;
	return true;
}

}
