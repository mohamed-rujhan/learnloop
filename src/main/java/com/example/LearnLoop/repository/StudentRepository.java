package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.LearnLoop.model.Student;

public interface StudentRepository extends MongoRepository<Student,String>  {
    @Query("{ 'userName': ?0, 'password': ?1 }")
    Student findByUserNameAndPassword(String userName, String password);

}
