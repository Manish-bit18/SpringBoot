package com.demo.transactiondemo1.controller;

import com.demo.transactiondemo1.entity.TransferRecord;
import com.demo.transactiondemo1.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public ResponseEntity<TransferRecord> getTransferDetails(@RequestParam Long id) {

        TransferRecord transferRecord =  transferService.getTransferDetails(id);
        return ResponseEntity.ok(transferRecord);
    }

    @PostMapping
    public ResponseEntity<String> transferRecord(@RequestBody TransferRecord transferRecord) throws Throwable {
        transferService.transfer(transferRecord.getFromAccountAt(),
                transferRecord.getToAccountAt(),
                transferRecord.getAmount());

        return ResponseEntity.ok("success");
    }
}
