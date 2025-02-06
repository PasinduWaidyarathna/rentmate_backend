package com.example.rentmate_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.rentmate_backend.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByName(String name);

    void deleteByName(String name);

}
