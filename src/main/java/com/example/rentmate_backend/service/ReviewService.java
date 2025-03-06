package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.Review;
import java.util.List;
public interface ReviewService {
    Review createReview(Review review);
    Review getReviewById(String id);
    List<Review> getAllReviews();
    Review updateReview(String id, Review review);
    void deleteReview(String id);
    List<Review> getReviewsByItemId(String itemId);
    Double getAverageRatingByItemId(String itemId);

}
