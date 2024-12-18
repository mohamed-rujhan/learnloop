package com.example.LearnLoop.model;

import java.security.Timestamp;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Reviews")
public class Review {

    private String reviewId;

    private String student_id;

    private String course_id;

    private int rating;

    private String comment;

    private Timestamp review_date;
    
}

