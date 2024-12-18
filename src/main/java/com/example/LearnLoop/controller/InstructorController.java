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
import com.example.LearnLoop.model.Instructor;
import com.example.LearnLoop.service.InstructorService;

@RestController
@RequestMapping({"/api/instructors"})
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    public InstructorController(){}

    @PostMapping
    public ResponseEntity <Instructor> createInstructor(@RequestBody Instructor instructor){
        Instructor createdInstructor =this.instructorService.createInstructor(instructor);
        return ResponseEntity.ok(createdInstructor);
    }

    @GetMapping({"/{instructorId}"})
    public ResponseEntity<Instructor> getInstructorById(@PathVariable String instructorId) 
    {
    Instructor instructor = this.instructorService.getInstructorById(instructorId);
    return instructor != null ? ResponseEntity.ok(instructor) :
    ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() //get all instructors
    {
    List<Instructor> instructor = this.instructorService.getAllInstructors();
    return ResponseEntity.ok(instructor);
    }

    @PutMapping({"/{instructorId}"})
    public ResponseEntity<Instructor> updateInstructor(@PathVariable String instructorId,@RequestBody Instructor instructor) 
    {
    Instructor updatedInstructor = this.instructorService.updateInstructor(instructorId, instructor);
    return updatedInstructor != null ? ResponseEntity.ok(updatedInstructor) :
    ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{instructorId}"})
    public ResponseEntity<Void> deleteInstructor(@PathVariable String instructorId) 
    {
    this.instructorService.deleteInstructor(instructorId);
    return ResponseEntity.noContent().build();
    }
}
