package com.example.rentcarspringboot2.dataAccess.abstracts;

import com.example.rentcarspringboot2.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}