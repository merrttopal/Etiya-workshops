package com.work.dataAccess.abstracs;

import com.work.entities.concrates.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer>{

}
