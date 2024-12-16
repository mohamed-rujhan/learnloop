package com.example.LearnLoop.service;

import com.example.LearnLoop.DTO.PaymentRequest;

public interface PaymentService {
    com.example.LearnLoop.DTO.PaymentResponse processPayment(PaymentRequest request);
}