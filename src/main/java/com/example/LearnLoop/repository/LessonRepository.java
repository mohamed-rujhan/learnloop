package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Lesson;

public interface LessonRepository extends MongoRepository<Lesson,String>  {

}
