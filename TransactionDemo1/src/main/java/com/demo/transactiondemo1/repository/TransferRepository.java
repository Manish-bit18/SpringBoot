package com.demo.transactiondemo1.repository;

import com.demo.transactiondemo1.entity.TransferRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecord , Long> {
}
