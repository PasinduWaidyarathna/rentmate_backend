package com.example.rentmate_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.rentmate_backend.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByItemId(String itemId);
    @Query(value = "{ 'itemId': ?0 }", fields = "{ 'rating': 1, '_id': 0 }")
    List<Review> findRatingsByItemId(String itemId);

}
