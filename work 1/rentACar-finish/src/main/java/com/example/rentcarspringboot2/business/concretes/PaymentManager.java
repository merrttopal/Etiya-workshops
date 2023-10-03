package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.CreditCardService;
import com.example.rentcarspringboot2.business.abstracts.PaymentService;
import com.example.rentcarspringboot2.business.requests.CreatePaymentRequest;
import com.example.rentcarspringboot2.business.rules.PaymentBussinessRules;
import com.example.rentcarspringboot2.core.utilities.exceptions.BusinessException;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.PaymentRepository;
import com.example.rentcarspringboot2.dataAccess.abstracts.RentalRepository;
import com.example.rentcarspringboot2.entities.concretes.Payment;
import com.example.rentcarspringboot2.entities.concretes.Rentals;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private ModelMapperService modelMapperService;
    private PaymentRepository paymentRepository;
    private RentalRepository rentalRepository;
    private CreditCardService creditCardService;
    private PaymentBussinessRules payRules;



    @Transactional
    @Override
    public void pay(CreatePaymentRequest createPaymentRequest) {
        if(creditCardService.cardPayment(createPaymentRequest.getCardDetail())){
            Payment payment = modelMapperService.forRequest().map(createPaymentRequest, Payment.class);
            double totalPrice= payRules.calculateTotalPrice(createPaymentRequest.getRentalId());
            payment.setTotalPrice( totalPrice);
            paymentRepository.save(payment);

            Rentals rentals = rentalRepository.findById(createPaymentRequest.getRentalId()).orElseThrow();
            rentals.setPaid(true);
            rentalRepository.save(rentals);

        }
        else { throw new BusinessException("Payment could not be received.");
        }
    }
}
