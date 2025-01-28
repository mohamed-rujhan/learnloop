package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.LearnLoop.model.Instructor;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
    @Query("{ 'userName': ?0, 'password': ?1 }")
        Instructor findByUserNameAndPassword(String userName, String password);
}