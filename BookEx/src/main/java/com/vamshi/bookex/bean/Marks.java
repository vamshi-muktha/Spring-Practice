package com.vamshi.bookex.bean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "mid")
public class Marks {
	@Id
	private int mid;
	private int marks;
	private String subject;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foreignkey_sno")
	private Student std;
}