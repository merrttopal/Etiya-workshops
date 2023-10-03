package com.example.rentcarspringboot2.webApi.controllers;

import com.example.rentcarspringboot2.business.abstracts.CarColorService;
import com.example.rentcarspringboot2.business.requests.CreateCarColorRequest;
import com.example.rentcarspringboot2.business.requests.UpdateCarColorRequest;
import com.example.rentcarspringboot2.business.responses.GetAllColorsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdColorsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/colors")
@RestController
public class ColorController {
    private CarColorService carColorService;

    @GetMapping()
    public List<GetAllColorsResponse> getAll() {
        return carColorService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCarColorRequest createCarColorRequest) {
        this.carColorService.add(createCarColorRequest);
    }

    @GetMapping("{id}")
    public GetByIdColorsResponse getById(int id) {
        return carColorService.getById(id);

    }

    @DeleteMapping("{id}")
    public void delete(int id) {
        this.carColorService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarColorRequest updateCarColorRequest) {
        this.carColorService.update(updateCarColorRequest);
    }
}
