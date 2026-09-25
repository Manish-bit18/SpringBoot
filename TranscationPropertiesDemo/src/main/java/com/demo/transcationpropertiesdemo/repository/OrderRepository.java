package com.demo.transcationpropertiesdemo.repository;

import com.demo.transcationpropertiesdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
