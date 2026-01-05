package com.tcs.assessment4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.assessment4.bean.TranHistory;

@Repository
public interface TranhistoryRepo extends JpaRepository<TranHistory, Integer>{

}
