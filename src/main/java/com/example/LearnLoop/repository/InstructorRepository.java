package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.LearnLoop.model.Instructor;

public interface InstructorRepository extends MongoRepository<Instructor, String> {

}