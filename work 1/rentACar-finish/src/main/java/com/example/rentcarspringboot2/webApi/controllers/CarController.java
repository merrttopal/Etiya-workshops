package com.example.rentcarspringboot2.webApi.controllers;

import com.example.rentcarspringboot2.business.abstracts.CarService;
import com.example.rentcarspringboot2.business.requests.CreateCarRequest;
import com.example.rentcarspringboot2.business.requests.UpdateCarRequest;
import com.example.rentcarspringboot2.business.responses.GetAllCarsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdCarsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {
    private CarService carService;

    @GetMapping("/getall")
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCarRequest createCarRequest) {
        this.carService.add(createCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id) {
        this.carService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
        this.carService.update(updateCarRequest);
    }

    @GetMapping("/{id}")
    public GetByIdCarsResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }
}
