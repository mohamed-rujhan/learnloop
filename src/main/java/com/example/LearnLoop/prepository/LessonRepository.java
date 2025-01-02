package com.example.LearnLoop.prepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.pmodel.Lesson;

public interface LessonRepository extends MongoRepository<Lesson,String>  {

}
