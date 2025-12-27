package com.vamshi.bookex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.bookex.bean.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
