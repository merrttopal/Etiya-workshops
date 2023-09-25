package com.work.business.abstracts;

import com.work.business.concretes.requests.CreateBrandRequest;
import com.work.business.concretes.responses.GetAllBrandsResponse;

import java.util.List;

public interface BrandService  {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
}
