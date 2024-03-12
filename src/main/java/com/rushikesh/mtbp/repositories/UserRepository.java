package com.rushikesh.mtbp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rushikesh.mtbp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
