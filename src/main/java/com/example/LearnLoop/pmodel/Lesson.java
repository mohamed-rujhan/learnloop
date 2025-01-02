package com.example.LearnLoop.pmodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="Lesson")
public class Lesson {
 @Id
private String lessonId;
//@NonNull
private String courseId;
//@NonNull
private String title;
//@NonNull
private String content;
//@NonNull
private int duration;


 
}