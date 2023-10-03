package com.example.rentcarspringboot2.webApi.controllers;

import com.example.rentcarspringboot2.business.abstracts.RentalService;
import com.example.rentcarspringboot2.business.requests.CreateRentalRequest;
import com.example.rentcarspringboot2.business.requests.UpdateRentalRequest;
import com.example.rentcarspringboot2.business.responses.GetAllRentalResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalsController {


    private RentalService rentalService;


    @GetMapping("/getall")
    public List<GetAllRentalResponse> getAll() {
        return rentalService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void  add(@RequestBody CreateRentalRequest createRentalRequest){
        rentalService.add(createRentalRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

    @PutMapping("/{id}")
    public  void  update(UpdateRentalRequest updateRentalRequest){
        rentalService.update(updateRentalRequest);
    }

    @GetMapping("/{id}")
    public GetByIdRentalResponse getById(int id){
        return  rentalService.getById(id);
    }


}
