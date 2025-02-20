package com.example.LearnLoop.model;

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
private String username;
//@NonNull
private String email;
//@NonNull
private String password;

public Student(String username,String password)
{
    this.username=username;
    this.password=password;
}

 public String getStudentId() {
  return studentId;
 }

 public void setStudentId(String studentId) {
  this.studentId = studentId;
 }
 
 public String getUsername() { 
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {  
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}