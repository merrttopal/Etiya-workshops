package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreateCarRequest;
import com.example.rentcarspringboot2.business.requests.UpdateCarRequest;
import com.example.rentcarspringboot2.business.responses.GetAllCarsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();

    void add(CreateCarRequest createCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    GetByIdCarsResponse getById(int id);

    void delete(int id);
}
