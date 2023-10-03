package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreateRentalRequest;
import com.example.rentcarspringboot2.business.requests.UpdateRentalRequest;
import com.example.rentcarspringboot2.business.responses.GetAllRentalResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdRentalResponse;

import java.util.List;

public interface RentalService {

    List<GetAllRentalResponse> getAll();
    void add(CreateRentalRequest createRentalRequest) ;
    GetByIdRentalResponse getById(int id);
    void delete(int id);
    void  update(UpdateRentalRequest updateRentalRequest);



}
