package com.tcs.libraryms.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private int bid;
	private String bname;
	private String aname;
	private String pdate;
	private int noa;
	
	
	
	public Book() {
		super();
	}
	public Book(int bid, String bname, String aname, String pdate, int noa) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.aname = aname;
		this.pdate = pdate;
		this.noa = noa;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getNoa() {
		return noa;
	}
	public void setNoa(int noa) {
		this.noa = noa;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", aname=" + aname + ", pdate=" + pdate + ", noa=" + noa + "]";
	}
	
	
}
