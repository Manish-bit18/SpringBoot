package com.demo.transactiondemo1.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal balance;

    public void credit(BigDecimal amount){
        if(amount == null || amount.signum() < 0) {
            throw new RuntimeException("Amount must be Positive");
        }

        balance = balance.add(amount);
    }

    public void debit(BigDecimal amount){
        if(amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if(balance.compareTo(amount) < 0){
            throw new IllegalArgumentException("Insufficiemt Balance");
        }

        balance = balance.subtract(amount);
    }

}
