package com.example.rentcarspringboot2.business.rules;


import com.example.rentcarspringboot2.core.utilities.exceptions.BusinessException;
import com.example.rentcarspringboot2.dataAccess.abstracts.CarRepository;
import com.example.rentcarspringboot2.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RentalBusinessRules {
    private CarRepository carRepository;

    public boolean checkIfCarAvaible(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        if (car.getState() == 1) {
            return true;
        }
        throw new BusinessException("Car not avaible");
    }


}
