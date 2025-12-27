package com.vamshi.bookex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamshi.bookex.bean.Book;
import com.vamshi.bookex.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	BookRepo br;
	public Book getById(int bid) {
		// TODO Auto-generated method stub
		return br.getReferenceById(bid);
	}
	public void saveBook(Book b) {
		// TODO Auto-generated method stub
		br.save(b);
	}
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return br.findAll();
	}
	
}
