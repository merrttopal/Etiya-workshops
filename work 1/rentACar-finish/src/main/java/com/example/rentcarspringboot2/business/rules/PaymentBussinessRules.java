package com.example.rentcarspringboot2.business.rules;

import com.example.rentcarspringboot2.dataAccess.abstracts.CarRepository;
import com.example.rentcarspringboot2.dataAccess.abstracts.RentalRepository;
import com.example.rentcarspringboot2.entities.concretes.Car;
import com.example.rentcarspringboot2.entities.concretes.Rentals;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentBussinessRules {

    private CarRepository carRepository;
    private RentalRepository rentalRepository;

    public double calculateTotalPrice(int id){

        Rentals rentals =  rentalRepository.findById(id).orElseThrow();

        Car car = carRepository.findById(rentals.getCar().getId()).orElseThrow();

        double total = rentals.getRentedForDays()*car.getDailyPrice();

        return total;
    }

    public double calculateTotalPrice1(int id){

        Rentals rentals =  rentalRepository.findById(id).orElseThrow();

        Car car = carRepository.findById(rentals.getCar().getId()).orElseThrow();

        double total = rentals.getRentedForDays()*car.getDailyPrice();

        return total;
    }
}
