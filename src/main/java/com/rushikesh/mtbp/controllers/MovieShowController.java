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

import com.rushikesh.mtbp.entities.MovieShow;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.MovieShowRepository;
import com.rushikesh.mtbp.service.MovieShowService;

@RestController
@RequestMapping("api/shows")
public class MovieShowController {
	
	@Autowired
	MovieShowRepository movieShowRepository;
	
	@Autowired
	MovieShowService movieShowService;
	@PostMapping
	public ResponseEntity<MovieShow> addNewMovieShow(@RequestBody MovieShow movieShow){
		return new ResponseEntity<MovieShow>(movieShowService.addMovieShow(movieShow),HttpStatus.CREATED);
	}
	
	@PutMapping("{show_id}")
	public ResponseEntity<MovieShow> updateMovieShow(@PathVariable("show_id") int showId, @RequestBody MovieShow show){
		return new ResponseEntity<MovieShow>(movieShowService.updateMovieShow(showId, show), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{show_id}")
	public ResponseEntity<String> deleteMovieShow(@PathVariable("show_id") int showId){
		movieShowService.deleteMovieShow(showId);
		return new ResponseEntity<String>("MovieShow successfully deleted!!", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<MovieShow>> getAllMovieShows() {
		List<MovieShow> shows = movieShowRepository.findAll();

		if (shows.isEmpty()) {
			throw new EmptyDatabaseException("Shows table is empty!!");
		}

		return new ResponseEntity<>(shows, HttpStatus.FOUND);
	}
	
	@GetMapping("{show_id}")
	public ResponseEntity<MovieShow> getMovieShowById(@PathVariable("show_id") int showId){
		
		Optional<MovieShow> showOpt= movieShowRepository.findById(showId);
		if (showOpt.isEmpty()) {
			throw new EmptyDatabaseException("Show Not found!!");
		}
		return new ResponseEntity<>(showOpt.get(), HttpStatus.FOUND);
		
	}
	
	@GetMapping("movie/{movie_name}")
	public ResponseEntity<List<MovieShow>> getShowByMovieName(@PathVariable("movie_name") String movieName) {
		
		List<MovieShow> shows = movieShowRepository.findByMovieMovieName(movieName);
		if (shows.isEmpty()) {
			throw new EmptyDatabaseException("Shows Not found!!");
		}
		return new ResponseEntity<>(shows, HttpStatus.FOUND);
	}
	
	@GetMapping("theatre/{theatre_name}")
	public ResponseEntity<List<MovieShow>> getMovieShowByTheatreName(@PathVariable("theatre_name") String theatreName){
		List<MovieShow> shows = movieShowRepository.findByTheatreTheatreName(theatreName);
		if (shows.isEmpty()) {
			throw new EmptyDatabaseException("Shows Not found!!");
		}
		return new ResponseEntity<>(shows, HttpStatus.FOUND);
	}
	
	
	@GetMapping("movie/{movie_name}/city/{city}")
	public ResponseEntity<List<MovieShow>> getShowsByMovieNameAndCity(@PathVariable("movie_name") String movieName, @PathVariable("city") String city){
		List<MovieShow> shows = movieShowRepository.findByMovieMovieNameAndTheatreAddressCity(movieName, city);
		if (shows.isEmpty()) {
			throw new EmptyDatabaseException("Shows Not found!!");
		}
		return new ResponseEntity<>(shows, HttpStatus.FOUND);
	}
	
	@GetMapping("{movie_name}/{screen}")
	public ResponseEntity<List<MovieShow>> getShowsByMovieNameAndScreen(@PathVariable("movie_name") String movieName, @PathVariable("screen") String screen){
		List<MovieShow> shows = movieShowRepository.findByMovieMovieNameAndTheatreScreen(movieName, screen);
		if (shows.isEmpty()) {
			throw new EmptyDatabaseException("Shows Not found!!");
		}
		return new ResponseEntity<>(shows, HttpStatus.FOUND);
	}
	
	
	@GetMapping("{movie_name}/{screen}/{city}")
	public ResponseEntity<List<MovieShow>> getShowByMovieNameScreenAndCity(@PathVariable("movie_name") String movieName, @PathVariable("city") String city, @PathVariable("screen") String screen){
		List<MovieShow> shows = movieShowRepository.findByMovieMovieNameAndTheatreAddressCity(movieName, city);
		if (shows.isEmpty()) {
			throw new EmptyDatabaseException("Shows Not found!!");
		}
		return new ResponseEntity<>(shows, HttpStatus.FOUND);
	}
}
