package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.BrandService;
import com.example.rentcarspringboot2.business.requests.CreateBrandRequest;
import com.example.rentcarspringboot2.business.requests.UpdateBrandRequest;
import com.example.rentcarspringboot2.business.responses.GetAllBrandsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdBrandsResponse;
import com.example.rentcarspringboot2.business.rules.BrandBusinessRules;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.BrandRepository;
import com.example.rentcarspringboot2.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        //  List<GetAllBrandsResponse> brandsResponse=new ArrayList<>();
//        for(Brand brand1: brands){
//           GetAllBrandsResponse responseItem= new GetAllBrandsResponse();
//           responseItem.setId(brand1.getId());
//           responseItem.setName(brand1.getName());
//           brandsResponses.add(responseItem);
//        }
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandsResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandsResponse response = this.modelMapperService.forResponse()
                .map(brand, GetByIdBrandsResponse.class);
        return response;
    }
}

