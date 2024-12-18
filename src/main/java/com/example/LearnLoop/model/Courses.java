package com.example.LearnLoop.model;

import java.security.Timestamp;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

public class Courses {
@Id
private String course_id;
@NonNull
private String title;
@NonNull
private String description;
@NonNull
private String category;
@NonNull
private float price;
@NonNull
@Id
private String instructor_id;
@NonNull
private Timestamp created_at;
public void setCourse_id(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCourse_id'");
}


}
