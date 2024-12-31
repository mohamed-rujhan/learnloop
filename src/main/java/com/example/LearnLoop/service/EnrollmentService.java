package com.example.LearnLoop.service;

import java.util.List;

import com.example.LearnLoop.model.Enrollment;

public interface EnrollmentService {
    
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment getEnrollmentById(String enrollmentId);
    List<Enrollment> getAllEnrollments();
    Enrollment updateEnrollment (String enrollmentId, Enrollment enrollment);
    void deleteEnrollment(String enrollmentId);

}
