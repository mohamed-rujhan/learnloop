package com.example.LearnLoop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment,String> {

}