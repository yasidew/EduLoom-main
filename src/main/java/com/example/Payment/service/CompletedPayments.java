package com.example.Payment.service;

import com.example.Payment.entity.Completed_Payments;
import org.springframework.stereotype.Service;

@Service
public interface CompletedPayments {

    void saveCompletedPayment(Completed_Payments completedPayment);
}
