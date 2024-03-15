package com.rushikesh.mtbp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Movie;
import com.rushikesh.mtbp.entities.MovieShow;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
	List<MovieShow> findByMovieMovieName(String movieName);
	List<MovieShow> findByTheatreTheatreName(String theatreName);
	List<MovieShow> findByMovieMovieNameAndTheatreAddressCity(String movieName, String city);
	List<MovieShow> findByMovieMovieNameAndTheatreScreen(String movieName, String Screen);
	List<MovieShow> findByMovieMovieNameAndTheatreAddressCityAndTheatreScreen(String movieName, String city, String screen);
	
}
