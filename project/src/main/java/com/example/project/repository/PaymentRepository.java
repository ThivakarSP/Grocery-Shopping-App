package com.example.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
