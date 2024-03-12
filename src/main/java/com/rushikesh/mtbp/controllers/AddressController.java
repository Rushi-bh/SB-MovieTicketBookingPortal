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
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.AddressRepository;
import com.rushikesh.mtbp.service.AddressService;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;

	@Autowired
	AddressRepository addressRepository;

	@GetMapping
	public ResponseEntity<?> getAllAddresses() {

		List<Address> addresses = addressRepository.findAll();

		if (addresses.isEmpty()) {
			throw new EmptyDatabaseException("Address table is empty!!");
		}

		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);

	}

	@GetMapping("{addressId}")
	public ResponseEntity<Address> getAddress(@PathVariable("addressId") int addressId) {
		Optional<Address> opt = addressRepository.findById(addressId);

		if (opt.isEmpty()) {
			throw new EmptyDatabaseException("Address Not found!!");
		}

		return new ResponseEntity<Address>(opt.get(), HttpStatus.OK);

	}

	@GetMapping("city/{city}")
	public ResponseEntity<List<Address>> getAddressByCity(@PathVariable("city") String city) {
		List<Address> addresses = addressRepository.findByCity(city);

		if (addresses.isEmpty()) {
			throw new EmptyDatabaseException("Addresses not found!!");
		}
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);

	}

}
