package com.work.dataAccess.concretes;

import com.work.dataAccess.abstracs.BrandRepository;
import com.work.entities.concrates.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {
    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands= new ArrayList<>();
        brands.add(new Brand(1,"bmw"));
        brands.add(new Brand(2,"merso"));
        brands.add(new Brand(3,"audi"));
        brands.add(new Brand(4,"fiat"));
        brands.add(new Brand(5,"volvo"));
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }
}
