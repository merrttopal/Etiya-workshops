package com.example.springhomework.business.rules;

import com.example.springhomework.core.utilities.exceptions.BusinessException;
import com.example.springhomework.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LanguageBusinessRules {
    private LanguageRepository languageRepository;

    public void checkIfLanguageNameExists(String name) {
        if (this.languageRepository.existsByName(name)) {
            throw new BusinessException("Language Name Already Exists");
        }
    }
}
