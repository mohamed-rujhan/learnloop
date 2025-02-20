package com.example.LearnLoop.controller;

import com.example.LearnLoop.security.JwtUtil;
import com.example.LearnLoop.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, 
                                     @RequestParam String password,
                                     @RequestParam String role) {  
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // 🔥 Call loadUserByUsernameAndRole instead of loadUserByUsername
            UserDetails userDetails = userDetailsService.loadUserByUsernameAndRole(username, role);

            // 🔥 Generate JWT token with role
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
