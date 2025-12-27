package com.vamshi.bookex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.bookex.bean.Marks;

@Repository
public interface MarksRepo extends JpaRepository<Marks, Integer> {

}
