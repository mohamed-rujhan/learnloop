package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String>{

}
