package com.example.LearnLoop.repository;

import com.example.LearnLoop.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}