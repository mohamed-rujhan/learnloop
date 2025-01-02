package com.example.LearnLoop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearnLoop.model.Payment;
import com.example.LearnLoop.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = this.paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String paymentId) {
        Payment payment = this.paymentService.getPaymentById(paymentId);
        return payment != null ? ResponseEntity.ok(payment) :
            ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllpayments() {
        List<Payment> payments = this.paymentService.getAllPayment();
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable String paymentId, @RequestBody Payment payment) {
        Payment updatedPayment = this.paymentService.updatePayment(paymentId, payment);
        return updatedPayment != null ? ResponseEntity.ok(updatedPayment) :
            ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{paymentId}"})
    public ResponseEntity<Void> deletePayment(@PathVariable String paymentId) {
        this.paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build();
    }
}

