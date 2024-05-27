package com.api_financeira_simplificada.controller;

import com.api_financeira_simplificada.domain.transaction.Transaction;
import com.api_financeira_simplificada.dto.TransactionDTO;
import com.api_financeira_simplificada.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transaction")
@Tag(name = "TransactionController")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO request) throws Exception {
        Transaction response = transactionService.createTransaction(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
