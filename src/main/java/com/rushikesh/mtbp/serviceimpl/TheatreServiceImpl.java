package com.rushikesh.mtbp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.entities.Theatre;
import com.rushikesh.mtbp.entities.Tier;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.TheatreRepository;
import com.rushikesh.mtbp.service.TheatreService;

public class TheatreServiceImpl implements TheatreService{

	@Autowired
	TheatreRepository theatreRepository;
	
	@Override
	public Theatre addNewTheatre(Theatre newTheatre) {
		return theatreRepository.save(newTheatre);
	}

	@Override
	public List<Theatre> getAllTheatres() {
		List<Theatre> theatres = theatreRepository.findAll();
		if (theatres.isEmpty()) {
			throw new EmptyDatabaseException("Theatre table is empty!!");
		}
		return theatres;
		
	}

	@Override
	public Theatre getTheatreByTheatreId(int theatreId) {
		Optional<Theatre> theatreOpt = theatreRepository.findById(theatreId);
		if (theatreOpt.isEmpty()) {
			throw new EmptyDatabaseException("Theatre Not found!!");
		}
		return theatreOpt.get();
	}

	@Override
	public Theatre updateTheatreDetails(int theatreId, Theatre theatre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTheatreDetails(int theatreId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Theatre> getTheatreByTheatreName(String theatreName) {
		List<Theatre> theatres = theatreRepository.findByTheatreName(theatreName);
		if (theatres.isEmpty()) {
			throw new EmptyDatabaseException("Theatres Not found!!");
		}
		return theatres;
	}

	@Override
	public List<Theatre> getTheatreByCity(String city) {
		List<Theatre> theatres = theatreRepository.findByAddressCity(city);
		if (theatres.isEmpty()) {
			throw new EmptyDatabaseException("Theatres Not found!!");
		}
		return theatres;
	}

	@Override
	public List<Theatre> getTheatreByState(String state) {
		List<Theatre> theatres = theatreRepository.findByAddressState(state);
		if (theatres.isEmpty()) {
			throw new EmptyDatabaseException("Theatres Not found!!");
		}
		return theatres;
	}

	@Override
	public List<Theatre> getTheatreByCountry(String country) {
		List<Theatre> theatres = theatreRepository.findByAddressCountry(country);
		if (theatres.isEmpty()) {
			throw new EmptyDatabaseException("Theatres Not found!!");
		}
		return theatres;
	}

	@Override
	public Theatre updateTheatreAddress(int theatreId, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getTheatreAddress(int theatreId) {
		Address address = theatreRepository.getAddressByTheatreId(theatreId);
		if (address == null) {
			throw new EmptyDatabaseException("Address Not found!!");
		}
		return address;
	}

	@Override
	public List<Tier> getTheatreTiers(int theatreId) {
		List<Tier> tiers = theatreRepository.getTiersByTheatreId(theatreId);
		if (tiers.isEmpty()) {
			throw new EmptyDatabaseException("Tier details Not found!!");
		}
		return tiers;
	}

}
