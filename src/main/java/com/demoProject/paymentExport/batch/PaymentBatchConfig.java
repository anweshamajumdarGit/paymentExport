package com.demoProject.paymentExport.batch;

import com.demoProject.paymentExport.dto.ExportPaymentRequest;
import com.demoProject.paymentExport.dto.PaymentResponse;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.web.client.RestClient;

import java.util.List;

@Configuration
public class PaymentBatchConfig {

    @Bean
    public Step paymentExportStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            RestClient restClient) {

        return new StepBuilder("paymentExportStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {

                    System.out.println("Starting payment export job...");

                    // 1. Call GET /payments
                    List<PaymentResponse> payments =
                            restClient.get()
                                    .uri("/payments")
                                    .retrieve()
                                    .body(new ParameterizedTypeReference<
                                            List<PaymentResponse>>() {});

                    if (payments == null || payments.isEmpty()) {
                        System.out.println("No payments found.");
                        return RepeatStatus.FINISHED;
                    }

                    int exportedCount = 0;

                    // 2. Filter ALLOCATED payments
                    for (PaymentResponse payment : payments) {

                        if (!"ALLOCATED".equalsIgnoreCase(
                                payment.status())) {

                            System.out.println(
                                    "Skipping payment: "
                                            + payment.paymentId());

                            continue;
                        }

                        // 3. Prepare export request
                        ExportPaymentRequest request =
                                new ExportPaymentRequest(
                                        payment.paymentId(),
                                        payment.amount(),
                                        payment.currency()
                                );

                        // 4. Call POST /exported-payments
                        restClient.post()
                                .uri("/exported-payments")
                                .body(request)
                                .retrieve()
                                .toBodilessEntity();

                        exportedCount++;

                        System.out.println(
                                "Successfully exported: "
                                        + payment.paymentId());
                    }

                    System.out.println(
                            "Total exported payments: " + exportedCount);

                    return RepeatStatus.FINISHED;

                }, transactionManager)
                .build();
    }

    @Bean
    public Job paymentExportJob(
            JobRepository jobRepository,
            Step paymentExportStep) {

            return new JobBuilder("paymentExportJob", jobRepository)
                .start(paymentExportStep)
                .build();
    }
}
