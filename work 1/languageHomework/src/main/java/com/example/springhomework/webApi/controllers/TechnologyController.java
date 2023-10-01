package com.example.springhomework.webApi.controllers;

import com.example.springhomework.business.abstracts.TechologyService;
import com.example.springhomework.business.requests.CreateTechnologyRequest;
import com.example.springhomework.business.responses.GetAllTechnologyResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologyController {
    private TechologyService techologyService;

    @GetMapping()
    public List<GetAllTechnologyResponse> getAll() {
        return techologyService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateTechnologyRequest request) {
        techologyService.add(request);
    }
}
