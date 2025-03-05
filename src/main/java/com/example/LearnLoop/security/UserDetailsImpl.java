package com.example.LearnLoop.security;

import com.example.LearnLoop.model.Student;
import com.example.LearnLoop.model.Instructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private String id;
    private String username;
    private String password;
    private String role;

    // Constructor for Student
    public UserDetailsImpl(Student student) {
        this.id = student.getStudentId();
        this.username = student.getUsername();
        this.password = student.getPassword();
        this.role = "STUDENT";
    }

    // Constructor for Instructor
    public UserDetailsImpl(Instructor instructor) {
        this.id = instructor.getInstructorId();
        this.username = instructor.getUsername();
        this.password = instructor.getPassword();
        this.role = "INSTRUCTOR";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // No special roles/permissions
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
