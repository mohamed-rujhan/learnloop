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

import com.example.LearnLoop.model.Student;
import com.example.LearnLoop.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = this.studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Student student = this.studentService.getStudentById(studentId);
        return student != null ? ResponseEntity.ok(student) :
            ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> student = this.studentService.getAllStudent();
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable String studentId, @RequestBody Student student) {
        Student updatedStudent = this.studentService.updateStudent(studentId, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) :
            ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{studentId}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable String studentId) {
        this.studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}

