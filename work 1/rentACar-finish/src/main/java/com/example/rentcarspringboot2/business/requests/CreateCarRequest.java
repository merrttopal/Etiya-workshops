package com.example.rentcarspringboot2.business.requests;

import com.example.rentcarspringboot2.entities.concretes.Model;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String plate;

    @NotNull
    @NotBlank
    private double dailyPrice;

    @NotNull
    @NotBlank
    private int modelYear;

    @NotNull
    @NotBlank
    private int state;

   private int modelId;


}
