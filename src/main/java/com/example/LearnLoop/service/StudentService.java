package com.example.LearnLoop.service;

import java.util.List;
import com.example.LearnLoop.model.Student;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(String id);

    Student updateStudent(String id, Student student);

    void deleteStudent(String id);
}