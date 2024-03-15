package com.rushikesh.mtbp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.entities.Payment;
import com.rushikesh.mtbp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByAddressCity(String city);
	List<User> findByAddressState(String state);
	List<User> findByEmail(String email);
	List<User> findByUserName(String name);
	
	@Query(value = "select u.address from User u where u.userId = ?1")
	Address getAddressByUserId(int userId);
	
	@Query(value = "select u.payments from User u where u.userId = ?1")
	List<Payment> getPaymentsByUserId(int userId);
}
