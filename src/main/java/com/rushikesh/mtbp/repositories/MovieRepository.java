package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

