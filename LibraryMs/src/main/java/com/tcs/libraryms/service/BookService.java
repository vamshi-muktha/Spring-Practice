package com.tcs.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.libraryms.bean.Book;
import com.tcs.libraryms.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo br;

	public void saveEmp(Book b) {
		// TODO Auto-generated method stub
		br.save(b);
	}

	public List<Book> getAllBooks() {
		return br.findAll();
	}

	public Book getBookByBid(int bid) {
		return br.getReferenceById(bid);
	}

	public List<Book> getAllBooksByAname(String name) {
		return br.getBooksByAname(name);
	}
	
	
	
}
