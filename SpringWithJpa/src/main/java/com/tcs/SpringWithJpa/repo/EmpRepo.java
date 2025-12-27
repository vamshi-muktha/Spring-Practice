package com.tcs.SpringWithJpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.SpringWithJpa.bean.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{
	public Employee findByEno(int id);
	public List<Employee> findByEname(String ename);
	public List<Employee> findByEmail(String email);
	public List<Employee> findByEnameOrEmail(String ename, String email);
	
	@Query("from Employee e order by e.ename")
	public List<Employee> findByEnameSort();
	
	
	@Query("from Employee e where e.sal=:sal order by e.ename")
	public List<Employee> findByEnameSort(int sal);
}
