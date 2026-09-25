package com.demo.transcationpropertiesdemo.service;

import com.demo.transcationpropertiesdemo.entity.PaymentAudit;
import com.demo.transcationpropertiesdemo.repository.PaymentAuditRepository;
import com.demo.transcationpropertiesdemo.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository){
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED,
                    isolation = Isolation.READ_COMMITTED)
    public void audit(Order order){
       PaymentAudit paymentAudit = new PaymentAudit(order.getPrice(),
               order.getId(), true);

       paymentAuditRepository.save(paymentAudit);


    }
}
