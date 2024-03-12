package com.rushikesh.mtbp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	List<Address> findByCity(String city);
	List<Address> findByState(String state);
}



