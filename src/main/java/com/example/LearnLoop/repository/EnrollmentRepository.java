package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.LearnLoop.model.Enrollment;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String>{

}
