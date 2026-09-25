package com.demo.transcationpropertiesdemo.service;

import com.demo.transcationpropertiesdemo.entity.Order;
import com.demo.transcationpropertiesdemo.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private PaymentAuditService paymentAuditService;

    public OrderService(OrderRepository orderRepository , PaymentAuditService paymentAuditService) {
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }


    public Order getOrderById(Long id){
        return orderRepository.getById(id);
    }


    public void placeOrder(Order order){
        orderRepository.save(order);

        paymentAuditService.audit(order);

    }

}
