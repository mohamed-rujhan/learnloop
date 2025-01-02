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
@Document(collection="Student")
public class Student {
 @Id
private String studentId;
//@NonNull
private String firstName;
//@NonNull
private String lastName;
//@NonNull
private String userName;
//@NonNull
private String email;
//@NonNull
private String password;

 public String getStudentId() {
  return studentId;
 }

 public void setStudentId(String studentId) {
  this.studentId = studentId;
 }
}