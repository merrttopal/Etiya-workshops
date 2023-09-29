package com.work.business.abstracts;

import com.work.business.concretes.requests.CreateBrandRequest;
import com.work.business.concretes.requests.UpdateBrandRequest;
import com.work.business.concretes.responses.GetAllBrandsResponse;
import com.work.business.concretes.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService  {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetByIdBrandResponse getById(int id);
}
