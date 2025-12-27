package com.vamshi.bookex.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sno")

public class Student {
	
	@Id
	private int sno;
	private String name;
	private int std;
	private String area;
	
	
	@OneToOne
	@JoinColumn(name = "sno")
	private Marks m;
	
	
	@OneToMany
	@JoinColumn(name = "sno")
	private List<Book> books;
}
