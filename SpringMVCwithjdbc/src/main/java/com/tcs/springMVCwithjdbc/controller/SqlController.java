package com.tcs.springMVCwithjdbc.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springMVCwithjdbc.jdbc.ReadData;

@RestController
public class SqlController {
	@Autowired
	ReadData rd;
	
	@RequestMapping("/getEmps")
	public String getEmps() throws SQLException {
		String ans = rd.getData("select * from EMP");
		return ans;
		
	}
	@RequestMapping("/getEmp/{id}")
	public String getEmpsId(@PathVariable int id) throws SQLException {
		String ans = rd.getData("select * from EMP where empno = " + id);
		return ans;
		
	}
	
	@DeleteMapping("/deleteEmp")
	public String deleteEmpId(@RequestParam int id) throws SQLException {
		rd.getData2("delete from EMP where empno = " + id);
		return "deleted";
		
	}
}
