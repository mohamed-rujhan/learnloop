package com.example.LearnLoop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.LearnLoop.model.ContactForm;
import com.example.LearnLoop.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173") 
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

            // Send email to your email address
            emailService.sendEmail("contact@example.com", subject, text);

            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send message: " + e.getMessage());
        }
    }
}