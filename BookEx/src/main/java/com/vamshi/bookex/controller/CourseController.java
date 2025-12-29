package com.vamshi.bookex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.bookex.bean.Course;
import com.vamshi.bookex.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService ss;
	
	@PostMapping("/savecrs")
	public String saveCrs(@RequestBody Course s) {
		ss.saveCrs(s);
		return "Course Saved";
	}
	
	
	
	@GetMapping("/getallcrs")
	public List<Course> getAll(){
		return ss.getAll();
	}
}