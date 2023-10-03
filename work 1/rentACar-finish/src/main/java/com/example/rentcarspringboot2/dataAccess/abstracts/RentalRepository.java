package com.example.rentcarspringboot2.dataAccess.abstracts;

import com.example.rentcarspringboot2.entities.concretes.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RentalRepository extends JpaRepository<Rentals, Integer> {
}