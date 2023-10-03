package com.example.rentcarspringboot2.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    private int rentalId;

    private Date paymentDate;

    private CreditCardRequest cardDetail;
}
