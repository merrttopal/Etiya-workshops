package com.example.rentcarspringboot2.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String plate;
    @NotNull

    private double dailyPrice;

    @NotNull
    private int modelYear;
    @NotNull
    private int state;
}
