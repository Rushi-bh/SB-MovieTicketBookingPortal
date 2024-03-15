package com.rushikesh.mtbp.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushikesh.mtbp.entities.Payment;
import com.rushikesh.mtbp.entities.Ticket;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.PaymentRepository;
import com.rushikesh.mtbp.service.PaymentsService;

@Service
public class PaymentServiceImpl implements PaymentsService {

	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment addNewPayment(Payment newPayment) {
		return paymentRepository.save(newPayment);
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		 if(payments.isEmpty())
		 {
			 throw new EmptyDatabaseException("Payments table is empty!!");
		 }
		 return payments;
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
		if (paymentOpt.isEmpty()) {
			throw new EmptyDatabaseException("Payment Not found!!");
		}
		return paymentOpt.get();
	}

	@Override
	public List<Payment> getPaymentsByUserId(int userId) {
		List<Payment> payments = paymentRepository.findByUserUserId(userId);
		if (payments.isEmpty()) {
			throw new EmptyDatabaseException("Payments for this user id not found!!");
		}
		return payments;
	}

	@Override
	public List<Payment> getPaymentsByPaymentDate(LocalDate paymentDate) {
		List<Payment> payments = paymentRepository.findByPaymentDate(paymentDate);
		if (payments.isEmpty()) {
			throw new EmptyDatabaseException("Payments for this payment date not found!!");
		}
		return payments;
	}

	@Override
	public List<Payment> getPaymentByPaymentStatus(String paymentStatus) {
		List<Payment> payments = paymentRepository.findByPaymentStatus(paymentStatus);
		if (payments.isEmpty()) {
			throw new EmptyDatabaseException("Payments for this status not found!!");
		}
		return payments;
	}

	@Override
	public List<Ticket> getTicketsByUserId(int userId) {
		List<Ticket> tickets = paymentRepository.getTicketsByUserId(userId);
		if (tickets.isEmpty()) {
			throw new EmptyDatabaseException("Tickets not found!!");
		}
		return tickets;
	}
	
	

}
