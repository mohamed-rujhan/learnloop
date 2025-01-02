
package com.example.LearnLoop.pcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.LearnLoop.pmodel.Course;
import com.example.LearnLoop.pservice.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = this.courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
    }

   
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable String courseId) {
        Course course = this.courseService.getCourseById(courseId);
        return course != null ? ResponseEntity.ok(course) :
            ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> course = this.courseService.getAllCourse();
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable String courseId, @RequestBody Course course) {
        Course updatedCourse = this.courseService.updateCourse(courseId, course);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) :
         ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
        this.courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}

