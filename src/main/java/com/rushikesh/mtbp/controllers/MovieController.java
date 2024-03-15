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

import com.rushikesh.mtbp.entities.Movie;
import com.rushikesh.mtbp.entities.Movie;
import com.rushikesh.mtbp.exceptions.EmptyDatabaseException;
import com.rushikesh.mtbp.repositories.MovieRepository;
import com.rushikesh.mtbp.service.MovieService;
import com.rushikesh.mtbp.utils.AddressRequest;

@RestController
@RequestMapping("api/movies")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieService movieService;

	@PostMapping
	public ResponseEntity<Movie> addNewMovie(Movie movie){
		Movie savedMovie =movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(savedMovie,HttpStatus.CREATED);
	}
	
	@PutMapping("{movie_id}")
	public ResponseEntity<Movie> updateAddressDetails(@PathVariable("movie_id") int movieId, @RequestBody Movie movie){
		Movie updatedMovie = movieService.updateMovie(movieId,movie);
		return new ResponseEntity<Movie>(updatedMovie,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{movie_id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("movie_id") int movieId){
		movieService.deleteMovie(movieId);
		return new ResponseEntity<String>("Movie with id "+movieId+" deleted successfully!!", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();

		if (movies.isEmpty()) {
			throw new EmptyDatabaseException("Movies table is empty!!");
		}

		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	@GetMapping("{movie_id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("movie_id") int movieId) {
		Optional<Movie> opt = movieRepository.findById(movieId);

		if (opt.isEmpty()) {
			throw new EmptyDatabaseException("Movie Not found!!");
		}

		return new ResponseEntity<Movie>(opt.get(), HttpStatus.OK);
	}

	@GetMapping("{movie_name}")
	public ResponseEntity<List<Movie>> getMovieByName(@PathVariable("movie_name") String movieName) {
		
		List<Movie> movies = movieRepository.findByMovieName(movieName);
		if (movies.isEmpty()) {
			throw new EmptyDatabaseException("Movie Not found!!");
		}
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}

}
