package com.tcs.springmvcrest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springmvcrest.bean.Employee;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class EmployeeController {
	Map<Integer, Employee> hm ;
	
	public EmployeeController() {
		hm = new HashMap<>();
		hm.put(1, new Employee(1, "Virat", 5000));
		hm.put(2, new Employee(2, "Rohit", 7000));
		hm.put(3, new Employee(3, "Kohli", 8000));
		hm.put(4, new Employee(4, "Dhobi", 2000));
		hm.put(5, new Employee(5, "Rahul", 9000));
		hm.put(6, new Employee(6, "Yadav", 4000));
		hm.put(7, new Employee(7, "Hadik", 5000));
	}
	
	@RequestMapping("/getemps")
	public List<Employee> getAllEmps(){
		return new ArrayList<>(hm.values());
	}
	
	@RequestMapping("/getemp/{emp}")
	public Employee getEmp(@PathVariable int emp){
		return hm.get(emp);
	}
	
	@RequestMapping("/getemp")
	public Employee getEmpQ(@RequestParam int empno){
		return hm.get(empno);
	}
	
	@PostMapping("/postemp")
	public String getEmpQ(@RequestBody Employee emp){
		if(hm.containsKey(emp.getEno()))return "Emplyee with eno already exists";
		hm.put(7, emp);
		return "Emp object saved";
	}
	
	@DeleteMapping("/deleteemp")
	public String getEmpD(@RequestParam int eno){
		if(hm.containsKey(eno)) {
			hm.remove(hm.remove(eno));
			return "Emplyee deleted";
		}
		else
		return "Emp not exist";
	}
	
	@PutMapping("updateemp")
	public String updateEmp(@RequestBody Employee emp) {
		//TODO: process PUT request
		if(hm.containsKey(emp.getEno())) {
			hm.put(emp.getEno(), emp);
			return "Employee data updated";
		}
		return "Employee data is not there";
	}
};
