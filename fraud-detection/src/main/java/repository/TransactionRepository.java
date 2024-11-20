package com.fraud.repository;

import com.fraud.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // You can add custom query methods if needed, e.g.:
    // List<Transaction> findByUserId(String userId);
}

