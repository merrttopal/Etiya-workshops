package com.work.dataAccess.abstracs;

import com.work.entities.concrates.Brand;

import java.util.List;


public interface BrandRepository {
    List<Brand> getAll();

}
