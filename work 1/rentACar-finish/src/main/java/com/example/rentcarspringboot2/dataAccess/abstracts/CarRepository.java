package com.example.rentcarspringboot2.dataAccess.abstracts;

import com.example.rentcarspringboot2.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
