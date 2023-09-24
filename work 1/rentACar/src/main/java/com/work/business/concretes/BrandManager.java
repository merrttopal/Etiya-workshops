package com.work.business.concretes;

import com.work.business.abstracts.BrandService;
import com.work.dataAccess.abstracs.BrandRepository;
import com.work.dataAccess.concretes.InMemoryBrandRepository;
import com.work.entities.concrates.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private InMemoryBrandRepository brandRepository;


    public BrandManager() {
    }

    public BrandManager(InMemoryBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {

        return brandRepository.getAll();
    }
}
