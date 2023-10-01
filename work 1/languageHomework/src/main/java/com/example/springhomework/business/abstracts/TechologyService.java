package com.example.springhomework.business.abstracts;

import com.example.springhomework.business.requests.CreateTechnologyRequest;
import com.example.springhomework.business.responses.GetAllTechnologyResponse;

import java.util.List;

public interface TechologyService {
    List<GetAllTechnologyResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest);
}
