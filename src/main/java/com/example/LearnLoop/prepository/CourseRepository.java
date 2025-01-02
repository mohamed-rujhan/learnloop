package com.example.LearnLoop.prepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.pmodel.Course;


public interface CourseRepository extends MongoRepository<Course,String>{

}
