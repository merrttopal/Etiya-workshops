package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.CarColorService;
import com.example.rentcarspringboot2.business.requests.CreateCarColorRequest;
import com.example.rentcarspringboot2.business.requests.UpdateCarColorRequest;
import com.example.rentcarspringboot2.business.responses.GetAllColorsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdColorsResponse;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.CarColorRepository;
import com.example.rentcarspringboot2.entities.concretes.CarColor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarColorManager implements CarColorService {

    private CarColorRepository carColorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllColorsResponse> getAll() {
        List<CarColor> colors = carColorRepository.findAll();
        List<GetAllColorsResponse> colorsResponse = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorsResponse.class)).collect(Collectors.toList());
        return colorsResponse;
    }

    @Override
    public void delete(int id) {
        this.carColorRepository.deleteById(id);
    }

    @Override
    public GetByIdColorsResponse getById(int id) {
        CarColor carColor = this.carColorRepository.findById(id).orElseThrow();
        GetByIdColorsResponse response = this.modelMapperService.forResponse()
                .map(carColor, GetByIdColorsResponse.class);
        return response;
    }

    @Override
    public void add(CreateCarColorRequest createCarColorRequest) {
        CarColor CarColor = this.modelMapperService.forRequest().map(createCarColorRequest, CarColor.class);
        this.carColorRepository.save(CarColor);
    }

    @Override
    public void update(UpdateCarColorRequest updateCarColorRequest) {
        CarColor carColor = this.modelMapperService.forRequest()
                .map(updateCarColorRequest, CarColor.class);
        this.carColorRepository.save(carColor);
    }
}
