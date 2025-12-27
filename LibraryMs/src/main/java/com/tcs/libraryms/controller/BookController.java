package com.tcs.libraryms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.libraryms.bean.Book;
import com.tcs.libraryms.service.BookService;


@RestController
public class BookController {
	@Autowired
	BookService bs;
	
	
	@PostMapping("/savebook")
	public ResponseEntity<String> saveemp(@RequestBody Book b) {
		bs.saveEmp(b);
		return new ResponseEntity<>("BookSaved", HttpStatus.OK);
		
	}
	
	@GetMapping("/getbooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> al = bs.getAllBooks();
		return new ResponseEntity<>(al, HttpStatus.OK);
		
	}
	
	@GetMapping("/getbook/{bid}")
	public ResponseEntity<Book> getAllBooks(@PathVariable("bid") int bid) {
		Book b = bs.getBookByBid(bid);
		return new ResponseEntity<>(b, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getbyaname/{name}")
	public ResponseEntity<List<Book>> getAllBooksByAname(@PathVariable("name") String name) {
		List<Book> al = bs.getAllBooksByAname(name);
		return new ResponseEntity<>(al, HttpStatus.OK);
		
	}
	
}
