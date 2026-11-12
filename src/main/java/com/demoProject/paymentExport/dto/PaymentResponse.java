package com.demoProject.paymentExport.dto;

import java.math.BigDecimal;

public record PaymentResponse(
        String paymentId,
        BigDecimal amount,
        String currency,
        String status
) {
}
