package com.example.LearnLoop.model;

//import java.security.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Course")
public class Course {
@Id
private String courseId;

private String title;
//@NonNull
private String description;
//@NonNull
private String category;
//@NonNull
private float price;
//@NonNull
private String instructorId;

//private Timestamp createdAt;

}



