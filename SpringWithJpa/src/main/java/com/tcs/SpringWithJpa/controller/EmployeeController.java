package com.tcs.SpringWithJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.SpringWithJpa.bean.Employee;
import com.tcs.SpringWithJpa.service.EmpService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	EmpService es;
	
	
	public EmployeeController() {
		
	}
	
	
	@PostMapping("/saveemp")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee emp) {
		es.save(emp);
		return new ResponseEntity<>("Employee saved", HttpStatus.OK);
	}
	
	@RequestMapping("/getemps")
	public ResponseEntity<List<Employee>> getAllEmps(){
		List<Employee> list = es.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping("/getemp/{emp}")
	public ResponseEntity<Employee> getEmp(@PathVariable("emp") int emp){
		if(emp < 0) throw new NullPointerException("Negative -ve value for input");
		Employee found = es.findById(emp);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		es.findById(emp);
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	
	@RequestMapping("/getemp")
	public ResponseEntity<Employee> getEmpQ(@RequestParam int empno){
		if(empno < 0)throw new NullPointerException("Negative -ve value for input");
		Employee found = es.findById(empno);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	

	
	@DeleteMapping("/deleteemp")
	public ResponseEntity<Boolean> getEmpD(@RequestParam int eno){
		boolean b = es.deleteById(eno);
		if(b) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(false, HttpStatus.OK);
	}
	
	@PutMapping("updateemp")
	public ResponseEntity<String> updateEmp(@RequestBody Employee emp) {
		String str = es.updateEmp(emp);
//		if(hm.containsKey(emp.getEno())) {
//			hm.put(emp.getEno(), emp);
//			return new ResponseEntity<>("Employee data updated", HttpStatus.OK);
//		}
		return new ResponseEntity<>("Employee data updated", HttpStatus.OK);
	}
	
	
	@GetMapping("/getbyname/{emp}")
	public ResponseEntity<List<Employee>> getEmpByEname(@PathVariable("emp") String emp){
		
		List<Employee> found = es.findByEname(emp);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		es.findByEname(emp);
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	
	
	@GetMapping("/getbyemail")
	public ResponseEntity<List<Employee>> getEmpByEmail(@RequestParam("emp") String emp){
		
		List<Employee> found = es.findByEmail(emp);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		es.findByEmail(emp);
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	
	@GetMapping("/getbyemailorname")
	public ResponseEntity<List<Employee>> getEmpByEmailorEmail(@RequestParam("ename") String ename, @RequestParam("email") String email){
		
		List<Employee> found = es.findByEnameOrEmail(ename, email);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	
	
	@GetMapping("/getbyenamesort")
	public ResponseEntity<List<Employee>> getEmpByEnameSort(){
		
		List<Employee> found = es.findByEnameSort();
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	
	@GetMapping("/getbyenamesalsort/{sal}")
	public ResponseEntity<List<Employee>> getEmpByEnameSalSort(@PathVariable int sal){
		
		List<Employee> found = es.findByEnameSort(sal);
		if(found == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(found, HttpStatus.OK);
	}
	
	@RequestMapping("/getemps/{pno}/{psize}")
	public ResponseEntity<List<Employee>> getAllEmpsbyPage(@PathVariable int pno, @PathVariable int psize){
		List<Employee> list = es.findByPage(pno, psize);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
}