package com.example.LearnLoop.model;

import java.security.Timestamp;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

public class Payment {
@Id
private String payment_id;
@Id
private String student_id;
@Id
private String course_id;
@NonNull
private float amount;
@NonNull
private Timestamp payment_date;
@NonNull
private String status ;
public void setPaymentId(String paymentId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setPaymentId'");
}
}
