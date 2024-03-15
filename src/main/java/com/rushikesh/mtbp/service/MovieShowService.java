package com.rushikesh.mtbp.service;

import com.rushikesh.mtbp.entities.MovieShow;

public interface MovieShowService {

	MovieShow addMovieShow(MovieShow movieShow);

	MovieShow updateMovieShow(int movieShowId, MovieShow movieShow);

	void deleteMovieShow(int movieShowId);
}
