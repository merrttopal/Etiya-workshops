package com.example.rentcarspringboot2.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIDMaintenanceResponse {
    private int id;
    private int state;
}
