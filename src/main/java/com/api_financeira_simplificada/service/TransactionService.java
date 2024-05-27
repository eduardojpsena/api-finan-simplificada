package com.api_financeira_simplificada.service;

import com.api_financeira_simplificada.domain.transaction.Transaction;
import com.api_financeira_simplificada.domain.user.User;
import com.api_financeira_simplificada.dto.TransactionDTO;
import com.api_financeira_simplificada.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;
    @Autowired
    private TransactionValidateService validateService;
    @Autowired
    private UserService userService;

    public Transaction createTransaction(TransactionDTO transactionRequest) throws Exception {
        User sender = userService.findUserById(transactionRequest.senderId());
        User receiver = userService.findUserById(transactionRequest.receiverId());

        this.validateService.validateAuthorizeTransaction();

        Transaction newTransaction = new Transaction();
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setValueTransaction(transactionRequest.value());
        newTransaction.setTimestamp(LocalDateTime.now());

        this.validateService.validateTransaction(newTransaction);
        this.saveTransaction(newTransaction);
        this.updateBalanceUser(sender, receiver, transactionRequest.value());

        return newTransaction;
    }

    public void saveTransaction(Transaction transaction) {
        this.repository.save(transaction);
    }

    public void updateBalanceUser(User sender, User receiver, BigDecimal valueTransaction) {
        sender.setBalance(sender.getBalance().subtract(valueTransaction));
        receiver.setBalance(receiver.getBalance().add(valueTransaction));

        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
    }
}
