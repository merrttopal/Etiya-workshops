package com.example.springhomework.webApi.controllers;

import com.example.springhomework.business.abstracts.LanguageService;
import com.example.springhomework.business.requests.CreateLanguageRequest;
import com.example.springhomework.business.requests.UpdateLanguageRequest;
import com.example.springhomework.business.responses.GetAllLanguageResponse;
import com.example.springhomework.business.responses.GetByIdLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
    private LanguageService languageService;


    @GetMapping()
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    // path kısmından al
    @GetMapping("/id")
    public GetByIdLanguageResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateLanguageRequest request) {
        languageService.add(request);
    }

    @PutMapping
    public void update(@RequestBody() UpdateLanguageRequest request) {
        this.languageService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.languageService.delete(id);
    }
}
