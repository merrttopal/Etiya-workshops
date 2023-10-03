package com.example.rentcarspringboot2.business.responses;

import com.example.rentcarspringboot2.entities.concretes.Model;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {
    private int id;
    private String plate;

    private double dailyPrice;

    private int modelYear;

    private int state;


}
