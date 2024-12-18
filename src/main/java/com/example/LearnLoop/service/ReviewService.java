package com.example.LearnLoop.service;

import java.util.List;

import com.example.LearnLoop.model.Review;

public interface ReviewService {

    Review createReview(Review review);
    Review getReviewById(String review_id);
    List<Review> getAllReviews();
    Review updateReview (String review_id, Review review);
    void deleteReview(String review_id);


}
