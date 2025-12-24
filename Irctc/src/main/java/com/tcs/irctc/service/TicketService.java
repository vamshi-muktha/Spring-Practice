package com.tcs.irctc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.irctc.models.Passenger;
import com.tcs.irctc.models.Ticket;
import com.tcs.irctc.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository tr;

	public Ticket book(Passenger pas) {
		int pnr = (int )(Math.random()*1000000) + 1;
		Ticket t = new Ticket(pnr, pas.getTno(), pas.getFrom(), pas.getTo(), pas.getJdate(), 100, pas.getName(), "WaitingList");
		tr.save(t);
		return t;
	}

	public Ticket getTicket(int pnr) {
		// TODO Auto-generated method stub
		Ticket t = tr.getReferenceById(pnr);
		return t;
	}
	
}
