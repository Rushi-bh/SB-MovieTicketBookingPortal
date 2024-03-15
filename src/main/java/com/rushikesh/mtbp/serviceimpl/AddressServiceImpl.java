package com.rushikesh.mtbp.serviceimpl;

import java.util.Optional;

import org.hibernate.sql.results.internal.StandardEntityGraphTraversalStateImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.exceptions.RecordNotFoundException;
import com.rushikesh.mtbp.repositories.AddressRepository;
import com.rushikesh.mtbp.service.AddressService;
import com.rushikesh.mtbp.utils.AddressRequest;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address saveAddress(Address newAddress) {

		Address savedAddress = addressRepository.save(newAddress);
		return savedAddress;
	}

	@Override
	public void deleteAddress(int addressId) {
		Optional<Address> opt = addressRepository.findById(addressId);
		if(opt.isEmpty()) throw new RecordNotFoundException("Address not found!!");
		addressRepository.deleteById(addressId);
	}

	@Override
	public Address updateAddress(int addressId, AddressRequest address) {
		Optional<Address> opt = addressRepository.findById(addressId);
		if(opt.isEmpty()) throw new RecordNotFoundException("Address not found!!");
		opt.get().setAddressLine(address.addressLine());
		opt.get().setCity(address.city());
		opt.get().setState(address.state());
		opt.get().setCountry(address.country());
		return addressRepository.save(opt.get());
	}

}
