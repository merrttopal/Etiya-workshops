package com.example.rentcarspringboot2.webApi.controllers;

import com.example.rentcarspringboot2.business.abstracts.BrandService;
import com.example.rentcarspringboot2.business.requests.CreateBrandRequest;
import com.example.rentcarspringboot2.business.requests.UpdateBrandRequest;
import com.example.rentcarspringboot2.business.responses.GetAllBrandsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdBrandsResponse;
import com.example.rentcarspringboot2.entities.concretes.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandsResponse getById(int id) {
        return brandService.getById(id);

    }

    @DeleteMapping("{id}")
    public void delete(int id) {
        this.brandService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }
}
