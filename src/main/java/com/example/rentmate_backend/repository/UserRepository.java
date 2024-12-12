package com.example.rentmate_backend.repository;

import com.example.rentmate_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
