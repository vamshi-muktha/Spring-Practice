package com.tcs.SpringWithJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.SpringWithJpa.bean.Employee;
import com.tcs.SpringWithJpa.repo.EmpRepo;

import jakarta.validation.Valid;


@Service
public class EmpService {
	@Autowired
	EmpRepo er;

	public void save(@Valid Employee emp) {
		// TODO Auto-generated method stub
		er.save(emp);
	}

	public Employee findById(int emp) {
		return er.findByEno(emp);
		// TODO Auto-generated method stub
		
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	

	public boolean deleteById(int eno) {
		er.deleteById(eno);
		return true;
	}

	public String updateEmp(Employee emp) {
		er.save(emp);
		return null;
	}
	
	public List<Employee> findByEname(String ename){
		return er.findByEname(ename);
	}
	
	public List<Employee> findByEmail(String email){
		return er.findByEmail(email);
	}
	
	
	public List<Employee> findByEnameOrEmail(String ename, String email){
		return er.findByEnameOrEmail(ename, email);
	}
	
	public List<Employee> findByEnameSort(){
		return er.findByEnameSort();
	}
	
	public List<Employee> findByEnameSort(int sal){
		return er.findByEnameSort(sal);
	}
}
