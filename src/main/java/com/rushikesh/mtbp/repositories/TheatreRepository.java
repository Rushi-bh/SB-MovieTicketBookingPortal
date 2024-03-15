package com.rushikesh.mtbp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.entities.Theatre;
import com.rushikesh.mtbp.entities.Tier;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
	
	List<Theatre> findByTheatreName(String theatreName);
	List<Theatre> findByAddressCity(String city);
	List<Theatre> findByAddressState(String state);
	List<Theatre> findByAddressCountry(String country);
	
	@Query(value = "select t.address from Theatre t where t.theatreId=?1")
	Address getAddressByTheatreId(int theatreId);
	
	@Query(value = "select t.tiers from Theatre t where t.theatreId=?1")
	List<Tier> getTiersByTheatreId(int theatreId);
	
}