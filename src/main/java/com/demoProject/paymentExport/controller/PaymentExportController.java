//package com.demoProject.paymentExport.controller;
//
//import com.demoProject.paymentExport.dto.ExportPaymentRequest;
//import com.demoProject.paymentExport.service.PaymentExportService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/exported-payments")
//public class PaymentExportController {
//
//    private final PaymentExportService service;
//
//    public PaymentExportController(
//            PaymentExportService service) {
//        this.service = service;
//    }
//
//    @PostMapping
//    public ResponseEntity<Void> exportPayment(
//            @RequestBody ExportPaymentRequest request) {
//
//        service.saveOrUpdate(request);
//
//        return ResponseEntity.ok().build();
//    }
//}