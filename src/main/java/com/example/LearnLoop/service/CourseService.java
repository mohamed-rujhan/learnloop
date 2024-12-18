package com.example.LearnLoop.service;

import java.util.List;
import com.example.LearnLoop.model.Courses;


public interface CourseService {

    Courses createCourse(Courses course);

    List<Courses> getAllCourses();

    Courses getCourseById(String id);

    Courses updateCourse(String id, Courses course);

    void deleteCourse(String id);
}
