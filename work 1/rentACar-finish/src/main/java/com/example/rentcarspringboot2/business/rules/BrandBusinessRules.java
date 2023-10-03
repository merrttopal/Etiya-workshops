package com.example.rentcarspringboot2.business.rules;

import com.example.rentcarspringboot2.core.utilities.exceptions.BusinessException;
import com.example.rentcarspringboot2.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists");
        }

    }
}
