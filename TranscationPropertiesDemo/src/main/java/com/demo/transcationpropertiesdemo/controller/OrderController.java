package com.demo.transcationpropertiesdemo.controller;

import com.demo.transcationpropertiesdemo.entity.Order;
import com.demo.transcationpropertiesdemo.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
        return ResponseEntity.ok().body(order);
    }

    @GetMapping
    public ResponseEntity<Order> getOrderById(@PathVariable  Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);

    }
}
