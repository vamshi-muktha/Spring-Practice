package com.vamshi.bookex.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Course {
	@Id
	private int cid;
	private String cname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "course_student",
	        joinColumns = @JoinColumn(name = "course_id"),
	        inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	private List<Student> stds;
}