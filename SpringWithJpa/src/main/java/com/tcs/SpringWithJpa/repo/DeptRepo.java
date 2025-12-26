package com.tcs.SpringWithJpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.SpringWithJpa.bean.Dept;

@Repository
public interface DeptRepo extends JpaRepository<Dept, String> {
	// additional query methods for Dept can be added here if needed
}
