package com.tcs.SpringWithJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.SpringWithJpa.bean.PfBankDetails;
import com.tcs.SpringWithJpa.repo.PfRepo;

@Service
public class PfService {
	@Autowired
	PfRepo pr;

	public void savepf(PfBankDetails pf) {
		// TODO Auto-generated method stub
		pr.save(pf);
	}

	public PfBankDetails getpf(int eno) {
		// TODO Auto-generated method stub
		return pr.getReferenceById(eno);
	}

	public List<PfBankDetails> getall() {
		// TODO Auto-generated method stub
		
		return pr.findAll();
	}

	public List<PfBankDetails> getbypf(String pfno) {
		// TODO Auto-generated method stub
		return pr.findByPfno(pfno);
	}
	
	
}
