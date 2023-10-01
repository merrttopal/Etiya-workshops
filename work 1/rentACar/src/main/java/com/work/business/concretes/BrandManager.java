package com.work.business.concretes;

import com.work.business.abstracts.BrandService;
import com.work.business.concretes.requests.CreateBrandRequest;
import com.work.business.concretes.requests.UpdateBrandRequest;
import com.work.business.concretes.responses.GetAllBrandsResponse;
import com.work.business.concretes.responses.GetByIdBrandResponse;
import com.work.dataAccess.abstracs.BrandRepository;
import com.work.entities.concrates.Brand;
import com.work.core.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
//        try {
//            List<Brand> brands = this.brandRepository.findAll();
//            List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();
//            for (Brand brand: brands) {
//                GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//                responseItem.setId(brand.getId());
//                responseItem.setName(brand.getName());
//                brandsResponses.add(responseItem);
//            }
//            return brandsResponses;
//        }catch (Exception e){
//            System.err.println(e);
//        }
//        return  null;
        List<Brand> brands= brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = brands.stream()
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());

        return brandsResponses;

    }

    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }


    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }
}
