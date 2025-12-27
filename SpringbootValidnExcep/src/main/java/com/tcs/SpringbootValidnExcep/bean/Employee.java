package com.tcs.SpringbootValidnExcep.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Employee {
	
	@NotNull
	@Min(value = 1, message = "give proper employee number")
	@Max(value = 30000, message = "should be less than 30k")
	private int eno;
	
	@NotEmpty
	@Min(value = 4, message = "ename is too small")
	@Max(value = 100, message = "ename is too large")
	private String ename;
	
	private int sal;
	
	@Length(min = 10, max = 15, message = "give proper phone num")
	private String phno;
	
	@NotEmpty
	@Min(value = 4, message = "address is too small")
	@Max(value = 20, message = "address is too long")
	private String address;
	
	@Email(message = "Give prper email")
	private String email;
	public Employee(int eno, String ename, int sal, String phno, String address, String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.phno = phno;
		this.address = address;
		this.email = email;
	}
	public Employee() {
		super();
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", phno=" + phno + ", address=" + address
				+ ", email=" + email + "]";
	}
	
	
}
