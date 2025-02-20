package com.example.LearnLoop.model;

//import java.security.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "enrollment")
public class Enrollment {

    @Id
    private String enrollmentId;

    private String studentId;

    private String courseId;

   //private Timestamp enrollmentDate;

    private String completionStatus;
    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }



}