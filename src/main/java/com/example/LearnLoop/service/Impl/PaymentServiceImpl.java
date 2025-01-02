package com.example.LearnLoop.service.Impl;

import com.example.LearnLoop.pmodel.Payment;
import com.example.LearnLoop.prepository.PaymentRepository;
import com.example.LearnLoop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(String paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.orElse(null);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(String paymentId, Payment payment) {
        if (paymentRepository.existsById(paymentId)) {
            payment.setPaymentId(paymentId);
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public void deletePayment(String paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}

