package com.vamshi.bookex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamshi.bookex.bean.Student;
import com.vamshi.bookex.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;

	public void saveStd(Student s) {
		// TODO Auto-generated method stub
		sr.save(s);
	}

	public Student getById(int sid) {
		// TODO Auto-generated method stub
		return sr.getReferenceById(sid);
	}

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}
}
