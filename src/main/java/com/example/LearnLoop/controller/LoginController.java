package com.example.LearnLoop.controller;

import com.example.LearnLoop.model.Student;
import com.example.LearnLoop.model.Instructor;
import com.example.LearnLoop.service.StudentService;
import com.example.LearnLoop.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private InstructorService instructorService;

    // Login for Students
    @PostMapping("/student")
    public ResponseEntity<?> loginStudent(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassword();

        Student student = studentService.findByUserNameAndPassword(username, password);
        if (student == null) {
            return ResponseEntity.status(401).body("Invalid username or password for student");
        }

        return ResponseEntity.ok(student); // Return student details if successful
    }

    // Login for Instructors
    @PostMapping("/instructor")
    public ResponseEntity<?> loginInstructor(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassword();

        Instructor instructor = instructorService.findByUserNameAndPassword(username, password);
        if (instructor == null) {
            return ResponseEntity.status(401).body("Invalid username or password for instructor");
        }

        return ResponseEntity.ok(instructor); // Return instructor details if successful
    }

    // DTO for Login Request
    static class LoginRequest {
        private String userName;
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
