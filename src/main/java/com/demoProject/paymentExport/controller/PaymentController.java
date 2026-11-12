package com.demoProject.paymentExport.controller;


import com.demoProject.paymentExport.dto.ExportPaymentRequest;
import com.demoProject.paymentExport.entity.ExportedPayment;
import com.demoProject.paymentExport.entity.Payment;
import com.demoProject.paymentExport.service.PaymentService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping("/exported-payments")
    @ResponseStatus(HttpStatus.CREATED)
    public ExportedPayment exportPayment(
            @Valid @RequestBody ExportPaymentRequest request) {

        return paymentService.exportPayment(request);
    }
}
