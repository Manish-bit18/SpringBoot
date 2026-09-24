package com.demo.transactiondemo1.service;

import com.demo.transactiondemo1.entity.Account;
import com.demo.transactiondemo1.entity.TransferRecord;
import com.demo.transactiondemo1.repository.AccountRepository;
import com.demo.transactiondemo1.repository.TransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private TransferRepository transferRepository;
    private AccountRepository accountRepository;

    public TransferService(TransferRepository transferRepository ,  AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    public TransferRecord getTransferDetails(Long id){
        return transferRepository.getById(id);
    }

    @Transactional
    public void transfer(Long fromAccountId,
                         Long toAccountId,
                         BigDecimal amount) throws Throwable{

        Account fromAccount = accountRepository.findById(fromAccountId).
                orElseThrow(() -> new RuntimeException("User not found"));

        Account toAccount  = accountRepository.findById(toAccountId).
                orElseThrow(() -> new RuntimeException("User not found"));

        fromAccount.debit(amount);
        accountRepository.saveAndFlush(fromAccount);


        toAccount.credit(amount);
        accountRepository.saveAndFlush(toAccount);


        transferRepository.save(new TransferRecord(
                amount,
                toAccountId,
                fromAccountId,
                LocalDate.now()
        ));
        transferRepository.flush();
    }
}
