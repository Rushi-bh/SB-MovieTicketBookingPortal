package com.rushikesh.mtbp.service;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.utils.AddressRequest;

public interface AddressService {

	Address saveAddress(Address newAddress);

	void deleteAddress(int addressId);

	Address updateAddress(int addressId, AddressRequest address);
}
