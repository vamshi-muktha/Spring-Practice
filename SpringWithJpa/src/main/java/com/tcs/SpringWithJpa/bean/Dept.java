package com.tcs.SpringWithJpa.bean;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "dept_info")
@Data
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String dno;
	private String dname;
	private String loc;
	private int cap;
	@OneToMany
	@JoinColumn(name = "dno")
	List<Employee> al;
	
}
