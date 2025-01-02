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
@Document(collection="Payment")
public class Payment {
 @Id
private String paymentId;
//@NonNull
private String studentId;
//@NonNull
private String courseId;
//@NonNull
private float amount;
//@NonNull
//private Timestamp paymentDate;
//@NonNull
private String PaymentStatus;

 
}