package com.example.LearnLoop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearnLoop.model.Enrollment;
import com.example.LearnLoop.service.EnrollmentService;

@RestController
@RequestMapping({"/api/enrollment"})
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    public EnrollmentController(){}

    @PostMapping
    public ResponseEntity <Enrollment> createEnrollment(@RequestBody Enrollment enrollment){
        Enrollment createdEnrollment =this.enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.ok(createdEnrollment);
    }

    @GetMapping({"/{enrollmentId}"})
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable String enrollmentId) 
    {
    Enrollment enrollment = this.enrollmentService.getEnrollmentById(enrollmentId);
    return enrollment != null ? ResponseEntity.ok(enrollment) :
    ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() 
    {
    List<Enrollment> enrollment = this.enrollmentService.getAllEnrollments();
    return ResponseEntity.ok(enrollment);
    }

    @PutMapping({"/{enrollmentId}"})
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable String enrollmentId,@RequestBody Enrollment enrollment) 
    {
    Enrollment updatedEnrollment = this.enrollmentService.updateEnrollment(enrollmentId, enrollment);
    return updatedEnrollment != null ? ResponseEntity.ok(updatedEnrollment) :
    ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{enrollmentId}"})
    public ResponseEntity<Void> deleteEnrollment(@PathVariable String enrollmentId) 
    {
    this.enrollmentService.deleteEnrollment(enrollmentId);
    return ResponseEntity.noContent().build();
    }
}



