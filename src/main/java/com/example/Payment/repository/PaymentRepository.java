package com.example.Payment.repository;

import com.example.Payment.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, Long> {

    boolean existsByLearnerIdAndCourseName(String learnerId, String courseName);
}
