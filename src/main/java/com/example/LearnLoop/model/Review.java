package com.example.LearnLoop.model;

//import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private String review_id;

    private String student_id;

    private String course_id;

    private int rating;

    private String comment;

    //private Timestamp review_date;

}
