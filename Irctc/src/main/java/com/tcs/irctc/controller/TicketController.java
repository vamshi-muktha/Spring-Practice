package com.tcs.irctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tcs.irctc.models.Passenger;
import com.tcs.irctc.models.Ticket;
import com.tcs.irctc.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TicketController {

	@Autowired
	TicketService ts;
	
	
	@PostMapping("/irctc/book")
	public Ticket book(@RequestBody Passenger pas) {
		//TODO: process POST request
		Ticket t = ts.book(pas);
		return t;
	}
	
	@GetMapping("/irctc/get")
	public Ticket getTicket(@RequestParam int pnr) {
		Ticket t = ts.getTicket(pnr);
		return t;
	}
	
	
}