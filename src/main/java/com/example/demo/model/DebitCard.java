package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DebitCard {
	@Id
	private String cardno ;
	
	private Date expirydate;
	private String customerName;
	private int zip;
	public String getCardno() {
		return cardno;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public int getZip() {
		return zip;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

}
