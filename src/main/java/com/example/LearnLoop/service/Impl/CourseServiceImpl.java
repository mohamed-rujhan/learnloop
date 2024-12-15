package com.example.LearnLoop.service.Impl;

import com.example.LearnLoop.model.Courses;
import com.example.LearnLoop.repository.CourseRepository;
import com.example.LearnLoop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository coursesRepository;

    @Override
    public Courses createCourse(Courses course) {
        return coursesRepository.save(course);
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses getCourseById(String id) {
        Optional<Courses> course = coursesRepository.findById(id);
        return course.orElse(null);
    }

    @Override
    public Courses updateCourse(String id, Courses course) {
        if (coursesRepository.existsById(id)) {
            course.setCourse_id(id); // Set the course ID to ensure the update
            return coursesRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(String id) {
        coursesRepository.deleteById(id);
    }
}
