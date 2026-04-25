package com.ecom.dto;

public class PaymentRequest {

    private Long orderId;
    private double amount;

    // constructor
    public PaymentRequest(Long orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    // getters & setters

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

    
    
}