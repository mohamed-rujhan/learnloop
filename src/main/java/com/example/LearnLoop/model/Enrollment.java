package com.example.LearnLoop.model;

//import java.security.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

<<<<<<< HEAD:src/main/java/com/example/LearnLoop/model/Enrollment.java
=======
//import com.mongodb.lang.NonNull;

>>>>>>> origin/pirashanth:src/main/java/com/example/LearnLoop/model/Student.java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD:src/main/java/com/example/LearnLoop/model/Enrollment.java
@Document(collection = "enrollment")
public class Enrollment {

    @Id
    private String enrollmentId;

    private String studentId;

    private String courseId;

   // private Timestamp enrollmentDate;

    private String completionStatus;


}
=======
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
>>>>>>> origin/pirashanth:src/main/java/com/example/LearnLoop/model/Student.java
