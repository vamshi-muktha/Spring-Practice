package com.vamshi.bookex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.bookex.bean.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
