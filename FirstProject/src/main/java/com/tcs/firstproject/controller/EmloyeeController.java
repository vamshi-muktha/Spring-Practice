package com.tcs.firstproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.firstproject.model.Employee;
import com.tcs.firstproject.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmloyeeController {
	@Autowired
	EmployeeService es;
	
	@PostMapping("/newemp")
	public String saveEmp(@RequestBody Employee emp) {
		es.saveEmp(emp);
		return "Employee Saved";
	}
	
	@GetMapping("/getemps")
	public List<Employee> getAllEmps() {
		List<Employee> al = es.getAllEmps();
		System.out.println(al);
		return al;
	}
	
	
}