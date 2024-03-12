package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}

