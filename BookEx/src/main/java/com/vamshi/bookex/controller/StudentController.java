package com.vamshi.bookex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.bookex.bean.Student;
import com.vamshi.bookex.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping("/savestd")
	public String saveStd(@RequestBody Student s) {
		ss.saveStd(s);
		return "Student Saved";
	}
	
	@GetMapping("/getbysid")
	public Student getbyId(@RequestParam int sid) {
		return ss.getById(sid);
	}
	
	@GetMapping("/getallstds")
	public List<Student> getAll(){
		return ss.getAll();
	}
	
}
