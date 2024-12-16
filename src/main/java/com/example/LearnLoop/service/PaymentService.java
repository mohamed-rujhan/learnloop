package com.example.LearnLoop.service;

import com.example.LearnLoop.DTO.PaymentRequest;
import com.example.LearnLoop.controller.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
}