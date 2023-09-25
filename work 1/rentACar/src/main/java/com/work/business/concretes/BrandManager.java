package com.work.business.concretes;

import com.work.business.abstracts.BrandService;
import com.work.business.concretes.requests.CreateBrandRequest;
import com.work.business.concretes.responses.GetAllBrandsResponse;
import com.work.dataAccess.abstracs.BrandRepository;
import com.work.entities.concrates.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    final BrandRepository brandRepository;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        try {
            List<Brand> brands = brandRepository.findAll();
            List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();
            for (Brand brand: brands) {
                GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
                responseItem.setId(brand.getId());
                responseItem.setName(brand.getName());
                brandsResponses.add(responseItem);
            }
            return brandsResponses;
        }catch (Exception e){
            System.err.println(e);
        }

        return  null;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }
}
