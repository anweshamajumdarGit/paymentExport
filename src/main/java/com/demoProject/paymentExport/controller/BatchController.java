package com.demoProject.paymentExport.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/batch")
public class BatchController {

    private final JobLauncher jobLauncher;
    private final Job paymentExportJob;

    public BatchController(
            JobLauncher jobLauncher,
            Job paymentExportJob) {

        this.jobLauncher = jobLauncher;
        this.paymentExportJob = paymentExportJob;
    }

    @PostMapping("/run")
    public Map<String, Object> runBatchJob() throws Exception {

        JobExecution execution = jobLauncher.run(
                paymentExportJob,
                new JobParametersBuilder()
                        .addLong("run.id", System.currentTimeMillis())
                        .toJobParameters()
        );

        return Map.of(
                "jobExecutionId", execution.getId(),
                "jobStatus", execution.getStatus().toString()
        );
    }
}
