package com.vamshi.bookex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.bookex.bean.Marks;
import com.vamshi.bookex.bean.Student;
import com.vamshi.bookex.service.MarksService;

@RestController
public class MarksController {

	@Autowired
	MarksService ms;
	
	@PostMapping("/savemarks")
	public String saveMarks(@RequestBody Marks m) {
		ms.saveStd(m);
		return "Student Saved";
	}
	
	@GetMapping("/getbymid")
	public Marks getbyId(@RequestParam int sid) {
		return ms.getById(sid);
	}
	
	@GetMapping("/getallmarks")
	public List<Marks> getAll(){
		return ms.getAll();
	}
}
