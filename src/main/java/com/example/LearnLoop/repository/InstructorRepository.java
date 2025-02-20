package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.LearnLoop.model.Instructor;
import java.util.Optional;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
    Optional<Instructor> findByUsername(String username);  

    boolean existsByUsername(String username); 
}