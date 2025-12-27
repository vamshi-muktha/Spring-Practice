package com.tcs.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.irctc.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
