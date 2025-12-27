package com.vamshi.bookex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamshi.bookex.bean.Marks;
import com.vamshi.bookex.bean.Student;
import com.vamshi.bookex.repo.MarksRepo;

@Service
public class MarksService {
	@Autowired
	MarksRepo mr;

	public void saveStd(Marks m) {
		// TODO Auto-generated method stub
		mr.save(m);
	}

	public Marks getById(int sid) {
		// TODO Auto-generated method stub
		return mr.getReferenceById(sid);
	}

	public List<Marks> getAll() {
		// TODO Auto-generated method stub
		return mr.findAll();
	}
}
