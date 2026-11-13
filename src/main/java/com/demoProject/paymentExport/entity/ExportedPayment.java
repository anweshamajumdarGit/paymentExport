//package com.demoProject.paymentExport.entity;
//
//import jakarta.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(
//        name = "exported_payments",
//        uniqueConstraints = {
//                @UniqueConstraint(
//                        name = "uk_exported_payment_id",
//                        columnNames = "payment_id"
//                )
//        }
//)
//public class ExportedPayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "payment_id", nullable = false)
//    private String paymentId;
//
//    @Column(nullable = false, precision = 12, scale = 2)
//    private BigDecimal amount;
//
//    @Column(nullable = false, length = 3)
//    private String currency;
//
//    @Column(name = "exported_at", nullable = false)
//    private LocalDateTime exportedAt;
//
//    public ExportedPayment() {
//    }
//
//    @PrePersist
//    public void onCreate() {
//        if (exportedAt == null) {
//            exportedAt = LocalDateTime.now();
//        }
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(String paymentId) {
//        this.paymentId = paymentId;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public LocalDateTime getExportedAt() {
//        return exportedAt;
//    }
//}
