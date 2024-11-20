package com.fraud.service;

import com.fraud.model.Transaction;
import com.fraud.repository.TransactionRepository;
import com.fraud.utils.EmailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FraudDetectionService {
    private final TransactionRepository transactionRepository;
    private final EmailSender emailSender;

    public FraudDetectionService(TransactionRepository transactionRepository, EmailSender emailSender) {
        this.transactionRepository = transactionRepository;
        this.emailSender = emailSender;
    }

    public void detectFraudulentTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<Transaction> suspiciousTransactions = transactions.stream()
                .filter(this::isSuspicious)
                .collect(Collectors.toList());

        if (!suspiciousTransactions.isEmpty()) {
            String alertMessage = "Suspicious transactions detected:\n" + suspiciousTransactions;
            emailSender.sendEmail("admin@example.com", "Fraudulent Activity Detected", alertMessage);
        }
    }

    private boolean isSuspicious(Transaction transaction) {
        return transaction.getAmount() > 3000 ||
                !transaction.getLocation().equalsIgnoreCase("Nairobi");
    }
}
