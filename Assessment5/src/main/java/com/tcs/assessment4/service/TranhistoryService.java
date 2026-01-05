package com.tcs.assessment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.assessment4.bean.TranHistory;
import com.tcs.assessment4.repository.TranhistoryRepo;

@Service
public class TranhistoryService {
	@Autowired
	TranhistoryRepo tr;

	public void saveTran(TranHistory tran) {
		// TODO Auto-generated method stub
		tr.save(tran);
	}

	public List<TranHistory> getTrans() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}
}
