package com.example.springhomework.business.concretes;

import com.example.springhomework.business.abstracts.TechologyService;
import com.example.springhomework.business.requests.CreateTechnologyRequest;
import com.example.springhomework.business.responses.GetAllTechnologyResponse;
import com.example.springhomework.core.utilities.mappers.ModelMapperService;
import com.example.springhomework.dataAccess.abstracts.TechnologyRepository;
import com.example.springhomework.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechologyService {

    private TechnologyRepository technologyRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> responses = technologies.stream()
                .map(technology -> this.modelMapperService.forResponse()
                        .map(technology, GetAllTechnologyResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = this.modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
        technologyRepository.save(technology);
    }
}
