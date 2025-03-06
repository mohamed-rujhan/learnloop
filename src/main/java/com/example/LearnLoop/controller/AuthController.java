package com.example.LearnLoop.controller;

import com.example.LearnLoop.security.JwtUtil;
import com.example.LearnLoop.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.LearnLoop.model.LoginRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
public Map<String, String> login(@RequestBody LoginRequest loginRequest) {  
    try {
        // Extract credentials from the request body
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String role = loginRequest.getRole();

        // Validate credentials
        if (username == null || password == null || role == null) {
            throw new IllegalArgumentException("Username, password, and role are required");
        }
            // Manually authenticate the user by calling loadUserByUsernameAndRole
            UserDetails userDetails = userDetailsService.loadUserByUsernameAndRole(username, role);

            // Check if the password matches
            if (!new BCryptPasswordEncoder().matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("Invalid password");
            }

            // Generate JWT token with role
            String token = jwtUtil.generateToken(username, role);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("role", role);
            response.put("message", "Login successful!");
            return response;

        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login failed: " + e.getMessage());
            response.put("status", "error");
            return response;
        }
    }

}


