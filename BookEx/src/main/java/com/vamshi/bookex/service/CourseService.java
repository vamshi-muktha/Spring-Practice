package com.vamshi.bookex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamshi.bookex.bean.Course;
import com.vamshi.bookex.repo.CourseRepo;

@Service
public class CourseService {
	@Autowired
	CourseRepo cr;
	public void saveCrs(Course s) {
		// TODO Auto-generated method stub
		cr.save(s);
	}
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

}