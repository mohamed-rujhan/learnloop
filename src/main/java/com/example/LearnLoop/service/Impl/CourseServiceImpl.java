package com.example.LearnLoop.service.Impl;

import com.example.LearnLoop.pmodel.Course;
import com.example.LearnLoop.prepository.CourseRepository;
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
    public Course createCourse(Course course) {
        return coursesRepository.save(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return coursesRepository.findAll();
    }

    @Override
    public Course getCourseById(String courseid) {
        Optional<Course> course = coursesRepository.findById(courseid);
        return course.orElse(null);
    }

    @Override
    public Course updateCourse(String courseid, Course course) {
        if (coursesRepository.existsById(courseid)) {
            course.setCourseId(courseid);
            return coursesRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(String courseid) {
        coursesRepository.deleteById(courseid);
    }
}
