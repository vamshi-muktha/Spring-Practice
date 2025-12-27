package com.vamshi.bookex.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	private int bid;
	private String bname;
	private int pages;
	private int cost;
	
	@ManyToOne
	@JoinColumn(name = "sno")
	private Student std;
}

