package com.tcs.AssessmentWeek3.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class Account {
	
	@Min(value = 10000, message = "Acc no Too small")
	@Max(value = 1000000, message = "Acc no Too large")
	private int accNo;
	
	@Length(min = 5, max = 20, message = "name bw 5 and 20")
	private String aname;
	
	@Positive
	private int bal;
	
	@Length(min = 10, message = "Bid minimum 10")
	private String bid;
	private String area;
	
	@Email
	private String email;
	
	public Account(int accNo, String aname, int bal, String bid, String area, String email) {
		super();
		
		this.accNo = accNo;
		this.aname = aname;
		this.bal = bal;
		this.bid = bid;
		this.area = area;
		this.email = email;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", aname=" + aname + ", bal=" + bal + ", bid=" + bid + ", area=" + area
				+ ", email=" + email + "]";
	}
	
	
}
