package com.tcs.libraryms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.libraryms.bean.Book;


@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	public Book getBookByBid(int bid);

	public List<Book> getBooksByAname(String name);
}
