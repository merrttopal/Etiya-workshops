package com.work.business.concretes.requests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    private int id;
    private String name;
}
