package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Payment;
import com.ecom.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repo;
      
    
    @PostMapping()
    public Payment pay(@RequestBody Payment payment) {
        payment.setStatus("SUCCESS");
        return repo.save(payment);
    }

    @GetMapping
    public List<Payment> getAll() {
        return repo.findAll();
    }
}
