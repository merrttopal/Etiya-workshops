package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.ModelService;
import com.example.rentcarspringboot2.business.requests.CreateModelRequest;
import com.example.rentcarspringboot2.business.responses.GetAllModelsResponse;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.ModelRepository;
import com.example.rentcarspringboot2.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
