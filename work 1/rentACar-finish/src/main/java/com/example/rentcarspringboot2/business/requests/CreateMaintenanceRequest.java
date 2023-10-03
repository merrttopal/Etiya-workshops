package com.example.rentcarspringboot2.business.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaintenanceRequest {

    @NotNull
    private int carId;
    private Date sendDate;


}
