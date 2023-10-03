package com.example.rentcarspringboot2.dataAccess.abstracts;

import com.example.rentcarspringboot2.entities.concretes.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarColorRepository extends JpaRepository<CarColor,Integer> {
}
