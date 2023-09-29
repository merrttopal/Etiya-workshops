package com.work.webApi.controllers;

import com.work.business.abstracts.CarColorService;
import com.work.business.concretes.requests.CreateColorRequest;
import com.work.business.concretes.requests.UpdateColorRequest;
import com.work.business.concretes.responses.GetAllColorResponse;
import com.work.business.concretes.responses.GetByIdColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/color")
public class ColorController {
    private CarColorService carColorService;

    @GetMapping("/getAll")
    public List<GetAllColorResponse> getAll(){
        return carColorService.getAll();

    }
    @GetMapping("/{id}")
    public GetByIdColorResponse getById(@PathVariable int id){
        return carColorService.getById(id);
    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable int id){
        this.carColorService.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody() CreateColorRequest createColorRequest){
        this.carColorService.add(createColorRequest);

    }
    @PutMapping("/update")
    public void update(@RequestBody() UpdateColorRequest updateColorRequest){
        this.carColorService.update(updateColorRequest);
    }


}
