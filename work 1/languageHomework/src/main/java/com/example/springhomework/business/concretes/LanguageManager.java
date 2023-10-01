package com.example.springhomework.business.concretes;

import com.example.springhomework.business.abstracts.LanguageService;
import com.example.springhomework.business.requests.CreateLanguageRequest;
import com.example.springhomework.business.requests.UpdateLanguageRequest;
import com.example.springhomework.business.responses.GetAllLanguageResponse;
import com.example.springhomework.business.responses.GetByIdLanguageResponse;
import com.example.springhomework.business.rules.LanguageBusinessRules;
import com.example.springhomework.core.utilities.mappers.ModelMapperService;
import com.example.springhomework.dataAccess.abstracts.LanguageRepository;
import com.example.springhomework.entities.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;
    private LanguageBusinessRules languageBusinessRules;

    //@Autowired
    @Override
    public List<GetAllLanguageResponse> getAll() {

        List<Language> languages = languageRepository.findAll();

        // listeyi tek tek dolaşır her bir language'yi GetAllLanguageResponse'a çevir
        List<GetAllLanguageResponse> responses = languages.stream()
                .map(language -> this.modelMapperService.forResponse()
                        .map(language, GetAllLanguageResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        // orElseThrow bulamazsan hata fırlat demektir.
        Language language = this.languageRepository.findById(id).orElseThrow();

        GetByIdLanguageResponse response = this.modelMapperService.forResponse()
                .map(language, GetByIdLanguageResponse.class);
        return response;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {

        // createLanguageRequest'i language'ye çevir
        // yani kısaca createLanguageRequest'e gidip brand'e göre entityleri map ediyor
        this.languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getName());
        Language language = this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
        languageRepository.save(language);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language language = this.modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
        this.languageRepository.save(language);
    }

    @Override
    public void delete(int id) {
        this.languageRepository.deleteById(id);
    }
}
