package com.example.LearnLoop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.LearnLoop.model.ContactForm;
import com.example.LearnLoop.service.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:5173") 
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody ContactForm contactForm) {
        try {
            String subject = "New Message from " + contactForm.getName();
            String text = "Name: " + contactForm.getName() + "\n"
                    + "Email: " + contactForm.getEmail() + "\n"
                    + "Message: " + contactForm.getMessage();

            // Send email
            emailService.sendEmail("contact@example.com", subject, text);

            // Return success response
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            // Return error response
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }
}