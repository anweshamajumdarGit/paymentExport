package com.demoProject.paymentExport.service;

import com.demoProject.paymentExport.dto.ExportPaymentRequest;
import com.demoProject.paymentExport.entity.Payment;
import com.demoProject.paymentExport.repository.PaymentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment saveOrUpdate(ExportPaymentRequest request) {

        Payment payment = paymentRepository
                .findByPaymentId(request.paymentId())
                .orElseGet(Payment::new);

        payment.setPaymentId(request.paymentId());
        payment.setAmount(request.amount());
        payment.setCurrency(request.currency());

        return paymentRepository.save(payment);
    }

    public java.util.List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}