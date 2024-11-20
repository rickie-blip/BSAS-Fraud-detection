package com.fraud.controller;

import com.fraud.service.FraudDetectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud")
public class FraudController {

    private final FraudDetectionService fraudDetectionService;

    public FraudController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @GetMapping("/detect")
    public String detectFraud() {
        fraudDetectionService.detectFraudulentTransactions();
        return "Fraud detection completed. Check logs or emails for details.";
    }
}
