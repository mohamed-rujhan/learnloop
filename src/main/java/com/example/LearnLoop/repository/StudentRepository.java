package com.example.LearnLoop.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Student;

public interface StudentRepository extends MongoRepository<Student,String>  {
    Optional<Student> findByUsername(String username);
    boolean existsByUsername(String username);

}
