package com.example.rentcarspringboot2.webApi.controllers;

import com.example.rentcarspringboot2.business.abstracts.MaintenanceService;
import com.example.rentcarspringboot2.business.requests.CreateMaintenanceRequest;
import com.example.rentcarspringboot2.business.requests.UpdateMaintenanceRequest;
import com.example.rentcarspringboot2.business.responses.GetAllMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    private MaintenanceService maintenanceService;

    @GetMapping("/getAll")
    public List<GetAllMaintenanceResponse> getAll(){
        return maintenanceService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void  add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest){
        maintenanceService.add(createMaintenanceRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id){
        maintenanceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update (@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest){
        maintenanceService.update(updateMaintenanceRequest);
    }

}
