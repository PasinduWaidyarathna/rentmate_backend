package com.example.rentmate_backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rentmate_backend.model.UserA;

public interface UserRepositoryA extends MongoRepository<UserA, String> {
    Optional<UserA> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
