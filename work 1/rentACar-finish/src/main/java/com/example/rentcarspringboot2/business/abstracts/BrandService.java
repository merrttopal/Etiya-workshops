package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreateBrandRequest;
import com.example.rentcarspringboot2.business.requests.UpdateBrandRequest;
import com.example.rentcarspringboot2.business.responses.GetAllBrandsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdBrandsResponse;
import com.example.rentcarspringboot2.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetByIdBrandsResponse getById(int id);
}

