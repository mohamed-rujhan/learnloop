package com.example.LearnLoop.prepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.LearnLoop.pmodel.Payment;

public interface PaymentRepository extends MongoRepository<Payment,String>{

}
