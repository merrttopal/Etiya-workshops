package com.example.springhomework.dataAccess.abstracts;

import com.example.springhomework.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    boolean existsByName(String name);
}
