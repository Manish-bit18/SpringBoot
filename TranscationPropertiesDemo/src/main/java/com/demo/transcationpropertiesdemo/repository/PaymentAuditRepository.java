package com.demo.transcationpropertiesdemo.repository;

import com.demo.transcationpropertiesdemo.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit,Long> {
}
