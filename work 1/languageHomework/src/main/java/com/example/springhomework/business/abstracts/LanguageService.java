package com.example.springhomework.business.abstracts;

import com.example.springhomework.business.requests.CreateLanguageRequest;
import com.example.springhomework.business.requests.UpdateLanguageRequest;
import com.example.springhomework.business.responses.GetAllLanguageResponse;
import com.example.springhomework.business.responses.GetByIdLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguageResponse> getAll();

    GetByIdLanguageResponse getById(int id);

    void add(CreateLanguageRequest createLanguageRequest);

    void update(UpdateLanguageRequest updateLanguageRequest);

    void delete(int id);

}
