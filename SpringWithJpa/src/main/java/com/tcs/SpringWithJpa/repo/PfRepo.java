package com.tcs.SpringWithJpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.SpringWithJpa.bean.PfBankDetails;

@Repository
public interface PfRepo extends JpaRepository<PfBankDetails, Integer> {

	List<PfBankDetails> findByPfno(String pfno);

}
