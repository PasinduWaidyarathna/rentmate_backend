package com.example.rentmate_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.rentmate_backend.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByName(String name);

    void deleteByName(String name);

}
