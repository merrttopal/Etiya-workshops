package com.example.rentcarspringboot2.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdRentalResponse {
    private int id;

    private int rentedForDays;

    private double dailyPrice;

    private Date startedDate;

    private int carId;

    private boolean paid ;
}
