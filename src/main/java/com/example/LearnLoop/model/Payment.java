package com.example.LearnLoop.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    @Id
    private String studentId;
    @Id
    private String courseId;
    @Id
    private String transactionId;
    @NonNull
    private String cardNumber;
    @NonNull
    private double amount;
    @NonNull
    private Date paymentDate;

    public Payment(String studentId, String courseId, String transactionId, String cardNumber, double amount, Date paymentDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.transactionId = transactionId;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
}