package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
