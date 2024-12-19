package com.example.LearnLoop.model;

//import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "review")
public class Review {

    @Id
    private String reviewId;

    private String studentId;

    private String courseId;

    private int rating;

    private String comment;

    //private Timestamp review_date;

}
