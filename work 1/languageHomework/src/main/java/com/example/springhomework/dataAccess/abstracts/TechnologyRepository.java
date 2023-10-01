package com.example.springhomework.dataAccess.abstracts;

import com.example.springhomework.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
