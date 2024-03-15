package com.rushikesh.mtbp.service;

import java.util.List;

import com.rushikesh.mtbp.entities.Address;
import com.rushikesh.mtbp.entities.Theatre;
import com.rushikesh.mtbp.entities.Tier;

public interface TheatreService {
	
	Theatre addNewTheatre(Theatre newTheatre);
	List<Theatre> getAllTheatres();
	Theatre getTheatreByTheatreId(int theatreId);
	Theatre updateTheatreDetails(int theatreId, Theatre theatre);
	void deleteTheatreDetails(int theatreId);
	List<Theatre> getTheatreByTheatreName(String theatreName);
	List<Theatre> getTheatreByCity(String city);
	List<Theatre> getTheatreByState(String state);
	List<Theatre> getTheatreByCountry(String country);
	Theatre updateTheatreAddress(int theatreId, Address address);
	Address getTheatreAddress(int theatreId);
	List<Tier> getTheatreTiers(int theatreId);
	
}
