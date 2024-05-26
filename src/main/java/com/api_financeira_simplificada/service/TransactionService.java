package com.api_financeira_simplificada.service;

import com.api_financeira_simplificada.domain.transaction.Transaction;
import com.api_financeira_simplificada.domain.user.User;
import com.api_financeira_simplificada.dto.TransactionDTO;
import com.api_financeira_simplificada.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;
    @Autowired
    private UserService userService;

    public Transaction createTransaction(TransactionDTO transactionRequest) throws Exception {
        User sender = userService.findUserById(transactionRequest.senderId());
        User receiver = userService.findUserById(transactionRequest.receiverId());

        Transaction newTransaction = new Transaction();
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setValueTransaction(transactionRequest.value());
        newTransaction.setTimestamp(LocalDateTime.now());

        this.saveTransaction(newTransaction);

        return newTransaction;
    }

    public void saveTransaction(Transaction transaction) {
        this.repository.save(transaction);
    }
}
