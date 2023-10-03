package com.example.rentcarspringboot2.business.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {

    @NotNull
    private int carId;

    @NotNull
    private int rentedForDays;

    @NotNull
    private Date startedDate;

}
