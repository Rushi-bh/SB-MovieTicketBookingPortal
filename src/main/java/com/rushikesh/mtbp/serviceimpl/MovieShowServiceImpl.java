package com.rushikesh.mtbp.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rushikesh.mtbp.entities.Movie;
import com.rushikesh.mtbp.entities.MovieShow;
import com.rushikesh.mtbp.exceptions.RecordNotFoundException;
import com.rushikesh.mtbp.repositories.MovieShowRepository;
import com.rushikesh.mtbp.service.MovieShowService;

public class MovieShowServiceImpl implements MovieShowService {

	@Autowired
	MovieShowRepository movieShowRepository;

	@Override
	public MovieShow addMovieShow(MovieShow movieShow) {

		return movieShowRepository.save(movieShow);
	}

	@Override
	public MovieShow updateMovieShow(int movieShowId, MovieShow movieShow) {

		Optional<MovieShow> opt = movieShowRepository.findById(movieShowId);

		if (opt.isEmpty())
			throw new RecordNotFoundException("MovieShow not found!!");

		MovieShow updatedMovieShow = movieShowRepository.save(movieShow);

		return updatedMovieShow;

	}

	@Override
	public void deleteMovieShow(int movieShowId) {
		Optional<MovieShow> opt = movieShowRepository.findById(movieShowId);
		if (opt.isEmpty())
			throw new RecordNotFoundException("MovieShow not found!!");
		movieShowRepository.deleteById(movieShowId);

	}

}
