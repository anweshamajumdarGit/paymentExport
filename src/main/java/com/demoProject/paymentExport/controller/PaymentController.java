package com.demoProject.paymentExport.controller;

import com.demoProject.paymentExport.dto.ExportPaymentRequest;
import com.demoProject.paymentExport.entity.Payment;
import com.demoProject.paymentExport.service.PaymentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Get all exported payments
    @GetMapping("/exported-payments")
    public ResponseEntity<List<Payment>> getAllPayments() {

        return ResponseEntity.ok(
                paymentService.getAllPayments()
        );
    }

    // Insert or update exported payment
    @PostMapping("/exported-payments")
    public ResponseEntity<Payment> exportPayment(
            @RequestBody ExportPaymentRequest request) {

        Payment savedPayment =
                paymentService.saveOrUpdate(request);

        return ResponseEntity.ok(savedPayment);
    }
}