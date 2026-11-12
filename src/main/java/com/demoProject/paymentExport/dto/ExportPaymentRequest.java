package com.demoProject.paymentExport.dto;

import java.math.BigDecimal;

public record ExportPaymentRequest(
        String paymentId,
        BigDecimal amount,
        String currency
) {
}
