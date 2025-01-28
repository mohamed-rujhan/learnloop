package com.example.LearnLoop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Instructors")
public class Instructor {

    @Id
    private String instructorId;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    @Indexed(unique = true)
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String bio;

    private int instructor_rating;



}