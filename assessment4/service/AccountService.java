package com.tcs.assessment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.assessment4.bean.Account;
import com.tcs.assessment4.repository.AccountRepo;

import jakarta.validation.Valid;

@Service
public class AccountService {
	@Autowired
	AccountRepo ar;

	public void saveAcc(@Valid Account acc) {
		// TODO Auto-generated method stub
		ar.save(acc);
	}

	public Account getById(int ano) {
		// TODO Auto-generated method stub
		return ar.getReferenceById(ano);
	}

	public List<Account> getByBid(String bid) {
		// TODO Auto-generated method stub
		return ar.getByBid(bid);
	}
	
	
}
