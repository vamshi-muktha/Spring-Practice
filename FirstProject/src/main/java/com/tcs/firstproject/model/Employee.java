package com.tcs.firstproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private int id;
	private String name;
	private String grade;
	private int zone;
	private int sal;
	private String role;
	
//	public Employee(int id, String name, String grade, int zone, int sal) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.grade = grade;
//		this.zone = zone;
//		this.sal = sal;
//	}
//	public Employee() {
//		super();
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGrade() {
//		return grade;
//	}
//	public void setGrade(String grade) {
//		this.grade = grade;
//	}
//	public int getZone() {
//		return zone;
//	}
//	public void setZone(int zone) {
//		this.zone = zone;
//	}
//	public int getSal() {
//		return sal;
//	}
//	public void setSal(int sal) {
//		this.sal = sal;
//	}
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", grade=" + grade + ", zone=" + zone + ", sal=" + sal + "]";
//	}
	
	
	
}
