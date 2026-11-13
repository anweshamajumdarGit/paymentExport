//package com.demoProject.paymentExport.service;
//
//import com.demoProject.paymentExport.dto.ExportPaymentRequest;
//import com.demoProject.paymentExport.entity.ExportedPayment;
//import com.demoProject.paymentExport.repository.ExportedPaymentRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class PaymentExportService {
//
//    private final ExportedPaymentRepository repository;
//
//    public PaymentExportService(
//            ExportedPaymentRepository repository) {
//        this.repository = repository;
//    }
//
//    @Transactional
//    public void saveOrUpdate(ExportPaymentRequest request) {
//
//        ExportedPayment payment =
//                repository.findByPaymentId(request.paymentId())
//                        .orElseGet(ExportedPayment::new);
//
//        payment.setPaymentId(request.paymentId());
//        payment.setAmount(request.amount());
//        payment.setCurrency(request.currency());
//
//        repository.save(payment);
//    }
//}