package com.tcs.firstproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.firstproject.model.Employee;
import com.tcs.firstproject.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo es;
	

	public void saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		es.save(emp);
	}


	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		List<Employee> al = es.findAll();
		return al;
	}
	
}
