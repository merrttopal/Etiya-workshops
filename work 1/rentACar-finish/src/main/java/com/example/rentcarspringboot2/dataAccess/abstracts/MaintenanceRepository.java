package com.example.rentcarspringboot2.dataAccess.abstracts;

import com.example.rentcarspringboot2.entities.concretes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}