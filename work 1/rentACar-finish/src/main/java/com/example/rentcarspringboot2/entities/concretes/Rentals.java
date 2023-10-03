package com.example.rentcarspringboot2.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental")
@Data
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rentedForDays")
    private int rentedForDays;

    @Column(name = "startedDate")
    private Date startedDate;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @OneToOne(mappedBy = "rentals")
    private Payment payment;

    @Column(name = "paid")
    private boolean paid = false;

}
