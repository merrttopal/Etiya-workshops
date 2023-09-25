package com.work.entities.concrates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;
    String name;

}
