package com.example.LearnLoop.service;

import java.util.List;

import com.example.LearnLoop.model.Instructor;


public interface InstructorService {

    Instructor createInstructor(Instructor instructor);
    Instructor getInstructorById(String instrcutorId);
    List<Instructor> getAllInstructors();
    Instructor updateInstructor (String instructorId, Instructor instructor);
    void deleteInstructor(String instructorId);
    Instructor findByUserNameAndPassword(String userName, String password);

}