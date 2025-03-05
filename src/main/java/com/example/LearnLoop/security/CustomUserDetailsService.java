package com.example.LearnLoop.security;

import com.example.LearnLoop.model.Student;
import com.example.LearnLoop.model.Instructor;
import com.example.LearnLoop.repository.StudentRepository;
import com.example.LearnLoop.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public UserDetails loadUserByUsernameAndRole(String username, String role) throws UsernameNotFoundException {
        if (role.equalsIgnoreCase("STUDENT")) {
            Student student = studentRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Student not found"));
            return new User(
                    student.getUsername(),
                    student.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_STUDENT"))
            );
        } else if (role.equalsIgnoreCase("INSTRUCTOR")) {
            Instructor instructor = instructorRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Instructor not found"));
            return new User(
                    instructor.getUsername(),
                    instructor.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))
            );
        } else {
            throw new IllegalArgumentException("Invalid role specified");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Use loadUserByUsernameAndRole() instead.");
    }
}