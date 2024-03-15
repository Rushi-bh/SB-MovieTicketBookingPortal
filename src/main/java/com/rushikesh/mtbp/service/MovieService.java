package com.rushikesh.mtbp.service;

import com.rushikesh.mtbp.entities.Movie;


public interface MovieService {

	Movie saveMovie(Movie newMovie);
	Movie updateMovie(int movieId, Movie movie);
	void deleteMovie(int movieId);
	
}
