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

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.entities.Payment;
import com.rushikesh.mtbp.entities.User;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.UserRepository;

@RestController
@RequestMapping("api/users")
public class UsersController {

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new EmptyDatabaseException("Users table is empty!!");
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("{user_id}")
	public ResponseEntity<User> getUserByUserId(@PathVariable("user_id") int userId) {
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isEmpty()) {
			throw new EmptyDatabaseException("User not found!!");
		}
		return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
	}

	@GetMapping("city/{city}")
	public ResponseEntity<List<User>> getUsersByCity(@PathVariable("city") String city) {

		List<User> users = userRepository.findByAddressCity(city);
		if (users.isEmpty()) {
			throw new EmptyDatabaseException("Users not found for these city " + city + "!!");
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("state/{state}")
	public ResponseEntity<List<User>> getUsersByState(@PathVariable("state") String state) {

		List<User> users = userRepository.findByAddressState(state);
		if (users.isEmpty()) {
			throw new EmptyDatabaseException("Users not found for these State " + state + "!!");
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("email/{email}")
	public ResponseEntity<List<User>> getUsersByEmail(@PathVariable("email") String email) {

		List<User> users = userRepository.findByEmail(email);
		if (users.isEmpty()) {
			throw new EmptyDatabaseException("User Not Found!!");
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("name/{name}")
	public ResponseEntity<List<User>> getUsersByName(@PathVariable("name") String name) {

		List<User> users = userRepository.findByUserName(name);
		if (users.isEmpty()) {
			throw new EmptyDatabaseException("User Not Found!!");
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("address/{user_id}")
	public ResponseEntity<Address> getAddressByuserId(@PathVariable("user_id") int userId) {
		Address address = userRepository.getAddressByUserId(userId);
		if (address == null) {
			throw new EmptyDatabaseException("Address Not Found!!");
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
	@GetMapping("payments/{user_id}")
	public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable("user_id") int userId){
		List<Payment> payments = userRepository.getPaymentsByUserId(userId);
		if(payments.isEmpty()) {
			throw new EmptyDatabaseException("Payments Not Found for user id: "+userId+"!!");
		}
		return new ResponseEntity<List<Payment>>(payments,HttpStatus.OK);
	}
}
