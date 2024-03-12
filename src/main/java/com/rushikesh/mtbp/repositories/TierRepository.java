package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.Tier;

@Repository
public interface TierRepository extends JpaRepository<Tier, Integer> {
}
