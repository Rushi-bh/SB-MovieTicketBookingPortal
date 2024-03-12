package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
