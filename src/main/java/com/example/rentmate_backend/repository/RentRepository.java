package com.example.rentmate_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.rentmate_backend.model.Rent;

public interface RentRepository extends MongoRepository<Rent, String> {

}
