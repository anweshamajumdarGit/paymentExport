package com.demoProject.paymentExport.repository;

import com.demoProject.paymentExport.entity.ExportedPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportedPaymentRepository
        extends JpaRepository<ExportedPayment, Long> {

}
