package com.example.LearnLoop.service.Impl;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.LearnLoop.model.Instructor;
import com.example.LearnLoop.repository.InstructorRepository;
import com.example.LearnLoop.service.InstructorService;


@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public Instructor createInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }
    
    @Override
    public Instructor getInstructorById(String instructorId){
        Optional<Instructor> instructor=instructorRepository.findById(instructorId);
        return instructor.orElse(null);   
    }

    @Override
    public List<Instructor> getAllInstructors() {
    return instructorRepository.findAll();
    }

    @Override
    public Instructor updateInstructor(String instructorId, Instructor instructor) 
    {
    if (instructorRepository.existsById(instructorId)) 
    {
    instructor.setInstructorId(instructorId);
    return instructorRepository.save(instructor);
    }
    return null; 
    } 

    @Override
    public void deleteInstructor(String instructorId) {
    instructorRepository.deleteById(instructorId);
    }
}
