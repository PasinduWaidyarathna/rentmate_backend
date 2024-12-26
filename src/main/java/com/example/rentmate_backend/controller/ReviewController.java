package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.Review;
import com.example.rentmate_backend.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review")
@CrossOrigin(origins = "*")
@Tag(name="ReviewController",description="To perform operations on Reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create a new Review
    @Operation(
            summary = "POST operation on Reviews",
            description = "It is used to save Review object in database"
    )
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    // Get all Reviews
    @Operation(
            summary = "GET operation on Reviews",
            description = "Endpoint to fetch a list of all Reviews from the database"
    )
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Get Review by ID
    @Operation(
            summary = "GET - Find Review by ID",
            description = "Endpoint to retrieve a specific Review using their unique identifier"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // Update Review
    @Operation(
            summary = "PUT operation on Review",
            description = "Endpoint to update an existing Review's details using their ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(id, review);
        if (updatedReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    // Delete Review by ID
    @Operation(
            summary = "DELETE operation on Review",
            description = "Endpoint to remove a specific Review from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
