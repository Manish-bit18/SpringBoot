package com.demo.transactiondemo1.controller;

import com.demo.transactiondemo1.entity.Account;
import com.demo.transactiondemo1.repository.AccountRepository;
import com.demo.transactiondemo1.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount =  accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }



}
