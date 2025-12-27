package com.tcs.SpringWithJpa.bean;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eno")
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@NotNull
	@Min(value = 1, message = "give proper employee number")
	@Max(value = 30000, message = "should be less than 30k")
	private int eno;
	
	@NotEmpty
	@Length(min = 10, max = 15, message = "give proper name")
	private String ename;
	
	private int sal;
	
	@Length(min = 10, max = 15, message = "give proper phone num")
	private String phno;
	
	@NotEmpty
	@Length(min = 10, max = 15, message = "give proper address")
	private String address;
	
	@Email(message = "Give proper email")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "eno")
	private PfBankDetails pf;
	
//	private String dno;
	
	
	@OneToOne
	@JoinColumn(name = "dno")
	private Dept dt;
	
	

	
	
}