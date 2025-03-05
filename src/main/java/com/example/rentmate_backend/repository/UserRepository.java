package com.example.rentmate_backend.repository;

import com.example.rentmate_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByRole(String role);
    User findBySid(String sid);
}
