package com.demoProject.paymentExport.service;


import com.demoProject.paymentExport.dto.ExportPaymentRequest;
import com.demoProject.paymentExport.entity.ExportedPayment;
import com.demoProject.paymentExport.entity.Payment;
import com.demoProject.paymentExport.repository.ExportedPaymentRepository;
import com.demoProject.paymentExport.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ExportedPaymentRepository exportedPaymentRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            ExportedPaymentRepository exportedPaymentRepository) {

        this.paymentRepository = paymentRepository;
        this.exportedPaymentRepository = exportedPaymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Transactional
    public ExportedPayment exportPayment(ExportPaymentRequest request) {

        ExportedPayment exportedPayment = new ExportedPayment();

        exportedPayment.setPaymentId(request.paymentId());
        exportedPayment.setAmount(request.amount());
        exportedPayment.setCurrency(request.currency());

        return exportedPaymentRepository.save(exportedPayment);
    }
}
