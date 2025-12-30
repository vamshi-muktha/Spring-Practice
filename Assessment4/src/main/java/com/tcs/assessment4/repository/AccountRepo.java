package com.tcs.assessment4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.assessment4.bean.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{

	List<Account> getByBid(String bid);
	
}
