package com.example.rentcarspringboot2.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="maintenances")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "send_Date",updatable = false)
    private Date sendDate;

    @Column(name = "return_Date")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name="car_Id")
    private Car car;


}
