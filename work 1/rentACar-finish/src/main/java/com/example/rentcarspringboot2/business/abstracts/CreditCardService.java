package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreditCardRequest;

public interface CreditCardService {
    boolean cardPayment(CreditCardRequest creditCardRequest);
}
