package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
}