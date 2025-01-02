package com.example.LearnLoop.ervice;

import java.util.List;

import com.example.LearnLoop.model.Course;


public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourse();

    Course getCourseById(String id);

    Course updateCourse(String id, Course course);

    void deleteCourse(String id);
}
