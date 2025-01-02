package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Course;


public interface CourseRepository extends MongoRepository<Course,String>{

}
