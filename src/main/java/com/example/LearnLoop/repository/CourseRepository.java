package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Courses;


public interface CourseRepository extends MongoRepository<Courses,String>{

}
