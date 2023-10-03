package com.example.rentcarspringboot2.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payment")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name="rentalId")
    private Rentals rentals;

}
