package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.MovieShow;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
}
