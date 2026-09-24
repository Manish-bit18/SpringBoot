package com.demo.transactiondemo1.repository;

import com.demo.transactiondemo1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
