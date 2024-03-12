package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
