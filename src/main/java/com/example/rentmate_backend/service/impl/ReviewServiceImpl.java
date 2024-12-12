package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.review.ReviewException;
import com.example.rentmate_backend.model.Review;
import com.example.rentmate_backend.repository.ReviewRepository;
import com.example.rentmate_backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        review.setCreatedAt(new Date()); // Manually set createdAt
        review.setUpdatedAt(new Date()); // Initial updatedAt
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(String id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review updateReview(String id, Review updatedReview) {
        /*if (studentRepository.existsById(id)) {
            return studentRepository.save(student);
        }
        return null; // Return null or throw an exception if not found*/
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            // Map the updated properties from the incoming Review object
            Review upRew= existingReview.get();
            // Preserve the original createdAt
            updatedReview.setCreatedAt(upRew.getCreatedAt());

            // Update updatedAt
            updatedReview.setUpdatedAt(new Date());

            upRew.setReviewerId(updatedReview.getReviewerId());
            upRew.setRating(updatedReview.getRating());
            upRew.setComment(updatedReview.getComment());
            upRew.setItemId(updatedReview.getItemId());
            upRew.setUpdatedAt(new Date());
            return reviewRepository.save(upRew);
        } else {
            throw new ReviewException("Review with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }

}
