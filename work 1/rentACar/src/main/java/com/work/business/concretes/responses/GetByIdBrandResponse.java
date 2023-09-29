package com.work.business.concretes.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetByIdBrandResponse {
    private int id;
    private String name;
}
