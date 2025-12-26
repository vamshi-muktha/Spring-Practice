package com.tcs.SpringWithJpa.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eno")
@Entity
@Table(name = "pf_bank_details")
@Data
@NoArgsConstructor
public class PfBankDetails {
	@Id
	private int eno;
	
	private String pfno;
	private int accno;
	private String details;
	
	@OneToOne(mappedBy = "pf")
	private Employee emp;
}