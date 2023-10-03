package com.example.rentcarspringboot2.webApi.controllers;

import com.example.rentcarspringboot2.business.abstracts.PaymentService;
import com.example.rentcarspringboot2.business.requests.CreatePaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {
    private PaymentService paymentService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void pay(@RequestBody CreatePaymentRequest createPaymentRequest) {
        paymentService.pay(createPaymentRequest);
    }
}
