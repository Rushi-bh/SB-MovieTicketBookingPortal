package com.rushikesh.mtbp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.AddressRepository;
import com.rushikesh.mtbp.service.AddressService;
import com.rushikesh.mtbp.utils.AddressRequest;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;

	@Autowired
	AddressRepository addressRepository;

	
	@PostMapping
	public ResponseEntity<Address> addNewAddress(Address address){
		Address savedAddress =addressService.saveAddress(address);
		return new ResponseEntity<Address>(savedAddress,HttpStatus.CREATED);
	}
	
	@PutMapping("{address_id}")
	public ResponseEntity<Address> updateAddressDetails(@PathVariable("address_id") int addressId, @RequestBody AddressRequest addressDeatils){
		Address updatedAddress = addressService.updateAddress(addressId,addressDeatils);
		return new ResponseEntity<Address>(updatedAddress,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{address_id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("address_id") int addressId){
		addressService.deleteAddress(addressId);
		return new ResponseEntity<String>("Address with id "+addressId+" deleted successfully!!", HttpStatus.OK);
	}
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

		return new ResponseEntity<Address>(opt.get(), HttpStatus.FOUND);

	}

	@GetMapping("city/{city}")
	public ResponseEntity<List<Address>> getAddressByCity(@PathVariable("city") String city) {
		List<Address> addresses = addressRepository.findByCity(city);

		if (addresses.isEmpty()) {
			throw new EmptyDatabaseException("Addresses not found!!");
		}
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.FOUND);

	}
	@GetMapping("state/{state}")
	public ResponseEntity<List<Address>> getAddressByState(@PathVariable("state") String state) {
		List<Address> addresses = addressRepository.findByState(state);

		if (addresses.isEmpty()) {
			throw new EmptyDatabaseException("Addresses not found!!");
		}
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.FOUND);

	}

}
