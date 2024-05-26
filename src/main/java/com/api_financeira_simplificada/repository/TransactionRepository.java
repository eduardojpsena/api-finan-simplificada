package com.api_financeira_simplificada.repository;

import com.api_financeira_simplificada.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
