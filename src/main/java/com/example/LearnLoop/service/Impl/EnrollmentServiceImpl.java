package com.example.LearnLoop.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearnLoop.model.Enrollment;
import com.example.LearnLoop.repository.EnrollmentRepository;
import com.example.LearnLoop.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment createEnrollment(Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }
    
    @Override
    public Enrollment getEnrollmentById(String enrollmentId){
        Optional<Enrollment> enrollment=enrollmentRepository.findById(enrollmentId);
        return enrollment.orElse(null);   
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
    return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment updateEnrollment(String enrollmentId, Enrollment enrollment) 
    {
    if (enrollmentRepository.existsById(enrollmentId)) 
    {
    enrollment.setEnrollmentId(enrollmentId);
    return enrollmentRepository.save(enrollment);
    }
    return null; 
    } 

    @Override
    public void deleteEnrollment(String enrollmentId) {
    enrollmentRepository.deleteById(enrollmentId);
    }
}

