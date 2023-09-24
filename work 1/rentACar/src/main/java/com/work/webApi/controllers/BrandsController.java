package com.work.webApi.controllers;

import com.work.business.abstracts.BrandService;
import com.work.entities.concrates.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/getAll")
    public List<Brand> getAll(){
        return brandService.getAll();
    }


}
