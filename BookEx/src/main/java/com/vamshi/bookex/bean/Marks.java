package com.vamshi.bookex.bean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sno")
public class Marks {
	
	@Id
	private int sno;
	private int marks;
	private String subject;
	
	@OneToOne
	@JoinColumn(name = "sno")
	private Student std;
}
