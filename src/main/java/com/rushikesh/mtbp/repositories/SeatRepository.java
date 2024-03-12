package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}