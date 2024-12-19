package com.example.LearnLoop.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.LearnLoop.model.Review;
import com.example.LearnLoop.repository.ReviewRepository;
import com.example.LearnLoop.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review){
        return reviewRepository.save(review);
    }
    
    @Override
    public Review getReviewById(String reviewId){
        Optional<Review> review=reviewRepository.findById(reviewId);
        return review.orElse(null);   
    }

    @Override
    public List<Review> getAllReviews() {
    return reviewRepository.findAll();
    }

    @Override
    public Review updateReview(String reviewId, Review review) 
    {
    if (reviewRepository.existsById(reviewId)) 
    {
    review.setReviewId(reviewId);
    return reviewRepository.save(review);
    }
    return null; 
    } 

    @Override
    public void deleteReview(String reviewId) {
    reviewRepository.deleteById(reviewId);
    }

}
