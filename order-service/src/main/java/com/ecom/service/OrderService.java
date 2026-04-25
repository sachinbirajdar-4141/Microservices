package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ecom.dto.PaymentRequest;
import com.ecom.dto.PaymentResponse;
import com.ecom.entity.Orders;
import com.ecom.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Orders createOrder(Orders order) {

        // 1️⃣ order save करा
        order.setStatus("CREATED");
        Orders savedOrder = repo.save(order);

        // 2️⃣ payment service call करा
        PaymentRequest request = new PaymentRequest(
                savedOrder.getId(),
                1000   // dummy amount
        );

        PaymentResponse response = webClientBuilder.build()
                .post()
                .uri(".uri(\"http://localhost:6003/payments\")")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(PaymentResponse.class)
                .block();

        // 3️⃣ response handle करा
        if (response != null && response.getStatus().equals("SUCCESS")) {
            savedOrder.setStatus("CONFIRMED");
        } else {
            savedOrder.setStatus("FAILED");
        }

        return repo.save(savedOrder);
    }

	public List<Orders> getAll() {
		// TODO Auto-generated method stub
		return getAll();
	}
}