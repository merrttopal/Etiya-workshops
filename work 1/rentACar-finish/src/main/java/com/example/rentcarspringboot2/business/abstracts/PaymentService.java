package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreatePaymentRequest;

public interface PaymentService {

    void pay(CreatePaymentRequest createPaymentRequest);
}
