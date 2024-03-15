package com.rushikesh.mtbp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushikesh.mtbp.entities.Ticket;
import com.rushikesh.mtbp.entities.Ticket;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.TicketRepository;

@RestController
@RequestMapping("api/tickets")
public class TicketsController {

	@Autowired
	TicketRepository ticketRepository;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> getAllTickets(){
		List<Ticket> tickets = ticketRepository.findAll();
		 if(tickets.isEmpty())
		 {
			 throw new EmptyDatabaseException("Tickets table is empty!!");
		 }
		 return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("{ticket_id}")
	public ResponseEntity<Ticket> getTicketByTicketId(@PathVariable("ticket_id") int ticketId){
		Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
		if(ticketOpt.isEmpty()) {
			throw new EmptyDatabaseException("Ticket not found!!");
		}
		return new ResponseEntity<Ticket>(ticketOpt.get(), HttpStatus.OK);
	}
}
