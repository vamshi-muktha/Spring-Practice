package com.tcs.assessment4.bean;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accNo")
public class Account {
	@Id
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
	
	@OneToMany(mappedBy = "acc")
	private List<TranHistory> trans;
}
