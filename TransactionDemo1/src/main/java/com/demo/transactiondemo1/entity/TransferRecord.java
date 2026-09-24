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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@NoArgsConstructor
@Getter
@Entity
public class TransferRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private Long fromAccountAt;

    private Long toAccountAt;

    private LocalDate transferred_at;


    public TransferRecord(BigDecimal amount, Long fromAccountAt, Long toAccountAt, LocalDate transferred_at) {
        this.amount = amount;
        this.fromAccountAt = fromAccountAt;
        this.toAccountAt = toAccountAt;
        this.transferred_at = transferred_at;
    }
}


