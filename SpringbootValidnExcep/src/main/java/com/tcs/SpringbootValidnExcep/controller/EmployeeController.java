package com.tcs.SpringbootValidnExcep.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.SpringbootValidnExcep.bean.Employee;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	private HashMap<Integer, Employee> hm;
	public EmployeeController() {
		hm = new HashMap<>();
		hm.put(1, new Employee(1, "Virat", 5000, "989899090", "Tcs Adibatla", "virat@tcs.com"));
		hm.put(2, new Employee(2, "Rohit", 7000, "989889090", "Tcs Adibatla", "Rohit@tcs.com"));
		hm.put(3, new Employee(3, "Kohli", 8000, "989889090", "Tcs Adibatla", "Kohli@tcs.com"));
		hm.put(4, new Employee(4, "Dhobi", 2000, "989869090", "Tcs Adibatla", "Dhobi@tcs.com"));
		hm.put(5, new Employee(5, "Rahul", 9000, "989859090", "Tcs Adibatla", "Rahul@tcs.com"));
		hm.put(6, new Employee(6, "Yadav", 4000, "989849090", "Tcs Adibatla", "Yadav@tcs.com"));
		hm.put(7, new Employee(7, "Hadik", 5000, "989839090", "Tcs Adibatla", "Hadik@tcs.com"));
	}
	
	
	@PostMapping("/saveemp")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee emp) {
		if(hm.containsKey(emp.getEno()))return new ResponseEntity<>("Employee already exists", HttpStatus.OK);
		hm.put(emp.getEno(), emp);
		return new ResponseEntity<>("Employee saved", HttpStatus.OK);
	}
	
	@RequestMapping("/getemps")
	public ResponseEntity<List<Employee>> getAllEmps(){
		return new ResponseEntity<>(new ArrayList<>(hm.values()), HttpStatus.OK);
	}
	
	@RequestMapping("/getemp/{emp}")
	public ResponseEntity<Employee> getEmp(@PathVariable int emp){
		if(emp < 0)throw new NullPointerException("Negative -ve value for input");
		return new ResponseEntity<>(hm.get(emp), HttpStatus.OK);
	}
	
	@RequestMapping("/getemp")
	public ResponseEntity<Employee> getEmpQ(@RequestParam int empno){
		if(empno < 0)throw new NullPointerException("Negative -ve value for input");
		return new ResponseEntity<>(hm.get(empno), HttpStatus.OK);
	}
	

	
	@DeleteMapping("/deleteemp")
	public ResponseEntity<String> getEmpD(@RequestParam int eno){
		if(hm.containsKey(eno)) {
			hm.remove(hm.remove(eno));
			return new ResponseEntity<>("Emplyee deleted", HttpStatus.OK);
		}
		else
		return new ResponseEntity<>("Emp not exist", HttpStatus.OK);
	}
	
	@PutMapping("updateemp")
	public ResponseEntity<String> updateEmp(@RequestBody Employee emp) {
		//TODO: process PUT request
		if(hm.containsKey(emp.getEno())) {
			hm.put(emp.getEno(), emp);
			return new ResponseEntity<>("Employee data updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee data is not there", HttpStatus.OK);
	}
}
