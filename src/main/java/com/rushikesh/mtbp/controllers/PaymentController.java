package com.rushikesh.mtbp.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushikesh.mtbp.entities.Payment;
import com.rushikesh.mtbp.entities.Ticket;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.PaymentRepository;
import com.rushikesh.mtbp.service.PaymentsService;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	PaymentsService paymentService;

	@PostMapping
	public ResponseEntity<Payment> addNewPayment(@RequestBody Payment newPayment){
		return new ResponseEntity<Payment>(paymentService.addNewPayment(newPayment),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.getAllPayments(), HttpStatus.OK);
	}

	@GetMapping("{payment_id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("payment_id") int paymentId) {

		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
	}

	@GetMapping("user/{user_id}")
	public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable("user_id") int userId) {
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentsByUserId(userId), HttpStatus.OK);
	}

	@GetMapping("date/{payment_date}")
	public ResponseEntity<List<Payment>> getPaymentsByPaymentDate(@PathVariable("payment_date") LocalDate paymentDate) {
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentsByPaymentDate(paymentDate), HttpStatus.OK);
	}

	@GetMapping("status/{payment_status}")
	public ResponseEntity<List<Payment>> getPaymentsByPaymentStatus(
			@PathVariable("payment_status") String paymentStatus) {
		return new ResponseEntity<List<Payment>>(paymentService.getPaymentByPaymentStatus(paymentStatus),
				HttpStatus.OK);
	}

	@GetMapping("tickets/{user_id}")
	public ResponseEntity<List<Ticket>> getTicketsByUserId(@PathVariable("user_id") int userId) {
		
		return new ResponseEntity<List<Ticket>>(paymentService.getTicketsByUserId(userId), HttpStatus.OK);
	}
}
