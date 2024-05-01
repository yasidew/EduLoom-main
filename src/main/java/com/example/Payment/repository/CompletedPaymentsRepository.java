package com.example.Payment.repository;

import com.example.Payment.entity.Completed_Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedPaymentsRepository extends JpaRepository<Completed_Payments, Long> {
}
