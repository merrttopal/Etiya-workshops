package com.example.rentcarspringboot2.business.responses;


import com.example.rentcarspringboot2.entities.concretes.Car;
import com.example.rentcarspringboot2.entities.concretes.Payment;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalResponse {

    private int id;

    private int rentedForDays;

    private double dailyPrice;

    private Date startedDate;

    private int carId;

    private boolean paid ;
}
