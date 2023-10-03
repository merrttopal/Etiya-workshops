package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreateCarColorRequest;
import com.example.rentcarspringboot2.business.requests.UpdateBrandRequest;
import com.example.rentcarspringboot2.business.requests.UpdateCarColorRequest;
import com.example.rentcarspringboot2.business.responses.GetAllColorsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdColorsResponse;

import java.util.List;

public interface CarColorService {
    List<GetAllColorsResponse> getAll();

    void delete(int id);

    GetByIdColorsResponse getById(int id);

    void add(CreateCarColorRequest createCarColorRequest);

    void update(UpdateCarColorRequest updateCarColorRequest);

}
