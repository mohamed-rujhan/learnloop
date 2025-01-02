package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Student;

public interface StudentRepository extends MongoRepository<Student,String>  {

}
