package com.vamshi.bookex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.bookex.bean.Course;


@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

}