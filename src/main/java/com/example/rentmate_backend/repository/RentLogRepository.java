package com.example.rentmate_backend.repository;

import java.util.List;

import com.example.rentmate_backend.model.RentLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.rentmate_backend.model.Category;

public interface RentLogRepository extends MongoRepository<RentLog, String> {

}
