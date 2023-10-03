package com.example.rentcarspringboot2.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdColorsResponse {
    private int id;
    private String name;
}
