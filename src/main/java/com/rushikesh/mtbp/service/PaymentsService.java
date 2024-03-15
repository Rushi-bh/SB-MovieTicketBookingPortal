package com.rushikesh.mtbp.service;

import java.time.LocalDate;
import java.util.List;

import com.rushikesh.mtbp.entities.Payment;
import com.rushikesh.mtbp.entities.Ticket;

public interface PaymentsService {
	
	Payment addNewPayment(Payment newPayment);
	
	List<Payment> getAllPayments();
	
	Payment getPaymentById(int paymentId);
	List<Payment> getPaymentsByUserId(int userId);
	List<Payment> getPaymentsByPaymentDate(LocalDate paymentDate);
	List<Payment> getPaymentByPaymentStatus(String paymentStatus);
	List<Ticket> getTicketsByUserId(int userId);
}
