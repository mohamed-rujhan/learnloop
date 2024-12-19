package com.example.LearnLoop.service;

import java.util.List;

import com.example.LearnLoop.model.Review;

public interface ReviewService {

    Review createReview(Review review);
    Review getReviewById(String reviewId);
    List<Review> getAllReviews();
    Review updateReview (String reviewId, Review review);
    void deleteReview(String reviewId);

}
