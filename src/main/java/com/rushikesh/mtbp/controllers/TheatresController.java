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
import com.rushikesh.mtbp.entities.Theatre;
import com.rushikesh.mtbp.entities.Tier;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.TheatreRepository;
import com.rushikesh.mtbp.service.TheatreService;

@RestController
@RequestMapping("api/theatres")
public class TheatresController {

	@Autowired
	TheatreRepository theatreRepository;

	@Autowired
	TheatreService theatreService;

	@PostMapping
	public ResponseEntity<Theatre> addNewTheatre(@RequestBody Theatre newTheatre)
	{
		return new ResponseEntity<Theatre>(theatreService.addNewTheatre(newTheatre), HttpStatus.CREATED);
	}
	
	@PutMapping("{theatre_id}")
	public ResponseEntity<Theatre> updateTheatreDetails(@PathVariable("theatre_id") int theatreId, @RequestBody Theatre theatre){
		return new ResponseEntity<Theatre>(theatreService.updateTheatreDetails(theatreId, theatre),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{theatre_id}")
	public ResponseEntity<String> deleteTheatreDetails(@PathVariable("theatre_id") int theatreId){
		theatreService.deleteTheatreDetails(theatreId);
		return new ResponseEntity<String>("Theatre details deleted successfully!!", HttpStatus.OK);
	}
	
	@PutMapping("address/{theatre_id}")
	public ResponseEntity<Theatre> updateTheatreAddress(@PathVariable("theatre_id")int theatreId, @RequestBody Address address){
		return new ResponseEntity<Theatre>(theatreService.updateTheatreAddress(theatreId, address), HttpStatus.ACCEPTED);
	}
	@GetMapping
	public ResponseEntity<List<Theatre>> getAllTheatres() {

		return new ResponseEntity<List<Theatre>>(theatreService.getAllTheatres(), HttpStatus.OK);

	}

	@GetMapping("{theatre_id}")
	public ResponseEntity<Theatre> getTheatreById(@PathVariable("theatre_id") int theatreId) {
		return new ResponseEntity<Theatre>(theatreService.getTheatreByTheatreId(theatreId), HttpStatus.OK);
	}

	@GetMapping("name/{theatre_name}")
	public ResponseEntity<List<Theatre>> getTheatresByName(@PathVariable("theatre_name") String theatreName) {
		return new ResponseEntity<List<Theatre>>(theatreService.getTheatreByTheatreName(theatreName), HttpStatus.OK);
	}

	@GetMapping("city/{city}")
	public ResponseEntity<List<Theatre>> getTheatresByCity(@PathVariable("city") String city) {
		return new ResponseEntity<List<Theatre>>(theatreService.getTheatreByCity(city), HttpStatus.OK);
	}

	@GetMapping("state/{state}")
	public ResponseEntity<List<Theatre>> getTheatresByState(@PathVariable("state") String state) {
		return new ResponseEntity<List<Theatre>>(theatreService.getTheatreByState(state), HttpStatus.OK);
	}

	@GetMapping("country/{country}")
	public ResponseEntity<List<Theatre>> getTheatresByCountry(@PathVariable("country") String country) {
		return new ResponseEntity<List<Theatre>>(theatreService.getTheatreByCountry(country), HttpStatus.OK);
	}

	@GetMapping("address/{theatre_id}")
	public ResponseEntity<Address> getTheatreAddressByTheatreId(@PathVariable("theatre_id") int theatreId) {
		return new ResponseEntity<Address>(theatreService.getTheatreAddress(theatreId), HttpStatus.OK);
	}

	@GetMapping("tiers/{theatre_id}")
	public ResponseEntity<List<Tier>> getTheatreTiersByTheatreId(@PathVariable("theatre_id") int theatreId) {
		return new ResponseEntity<List<Tier>>(theatreService.getTheatreTiers(theatreId), HttpStatus.OK);
	}

}
