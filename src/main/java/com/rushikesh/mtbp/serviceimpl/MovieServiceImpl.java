package com.rushikesh.mtbp.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rushikesh.mtbp.entities.Movie;
import com.rushikesh.mtbp.exceptions.RecordNotFoundException;
import com.rushikesh.mtbp.repositories.MovieRepository;
import com.rushikesh.mtbp.service.MovieService;

public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie saveMovie(Movie newMovie) {
		return movieRepository.save(newMovie);
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {

		Optional<Movie> opt = movieRepository.findById(movieId);

		if (opt.isEmpty())
			throw new RecordNotFoundException("Address not found!!");

		Movie updatedMovie = movieRepository.save(movie);

		return updatedMovie;
	}

	@Override
	public void deleteMovie(int movieId) {
		Optional<Movie> opt = movieRepository.findById(movieId);
		if (opt.isEmpty())
			throw new RecordNotFoundException("Address not found!!");
		movieRepository.deleteById(movieId);

	}

}
