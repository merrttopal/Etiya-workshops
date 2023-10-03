package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.CreditCardService;
import com.example.rentcarspringboot2.business.requests.CreditCardRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreditCardManager implements CreditCardService {

    @Override
    public boolean cardPayment(CreditCardRequest creditCardRequest) {
        return true;
    }
}
