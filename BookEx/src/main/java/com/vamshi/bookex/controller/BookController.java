package com.vamshi.bookex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.bookex.bean.Book;
import com.vamshi.bookex.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bs;
	
	@PostMapping("/savebook")
	public String saveBook(@RequestBody Book b) {
		bs.saveBook(b);
		return "Book Saved";
	}
	
	@GetMapping("/getbyid")
	public Book getbyId(@RequestParam int bid) {
		return bs.getById(bid);
	}
	
	@GetMapping("/getallbooks")
	public List<Book> getAll(){
		return bs.getAll();
	}
}
