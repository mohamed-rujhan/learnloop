package com.example.LearnLoop.ervice;

import java.util.List;

import com.example.LearnLoop.model.Payment;

public interface PaymentService {

    Payment createPayment(Payment payment);

    List<Payment> getAllPayment();

    Payment getPaymentById(String id);

    Payment updatePayment(String id, Payment payment);

    void deletePayment(String id);
}