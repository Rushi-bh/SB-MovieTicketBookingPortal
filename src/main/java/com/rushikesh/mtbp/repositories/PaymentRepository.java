package com.rushikesh.mtbp.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Payment;
import com.rushikesh.mtbp.entities.Ticket;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByUserUserId(int userId);

	List<Payment> findByPaymentDate(LocalDate paymentDate);

	List<Payment> findByPaymentStatus(String paymentStatus);

	@Query(value = "select p.ticket from Payment p where p.user.userId=?1")
	List<Ticket> getTicketsByUserId(int userId);
}
