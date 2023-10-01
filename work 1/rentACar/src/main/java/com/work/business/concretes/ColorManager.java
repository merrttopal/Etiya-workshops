package com.work.business.concretes;


import com.work.business.abstracts.CarColorService;
import com.work.business.concretes.requests.CreateColorRequest;
import com.work.business.concretes.requests.UpdateColorRequest;
import com.work.business.concretes.responses.GetAllColorResponse;
import com.work.business.concretes.responses.GetByIdColorResponse;
import com.work.dataAccess.abstracs.CarColorRepository;
import com.work.entities.concrates.CarColor;
import com.work.core.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements CarColorService {

    private CarColorRepository carColorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllColorResponse> getAll() {
        List<CarColor> colors = carColorRepository.findAll();
        List<GetAllColorResponse> colorResponses =
                colors.stream().map(carColor -> modelMapperService.forResponse().
                        map(carColor, GetAllColorResponse.class))
                        .collect(Collectors.toList());
        return colorResponses;
    }

    @Override
    public void delete(int id) {
        this.carColorRepository.deleteById(id);

    }

    @Override
    public GetByIdColorResponse getById(int id) {
        CarColor carColor = this.carColorRepository.findById(id).orElseThrow();
        GetByIdColorResponse colorResponse = this.modelMapperService.forResponse().
                map(carColor, GetByIdColorResponse.class);
        return colorResponse;
    }

    @Override
    public void add(CreateColorRequest createColorRequest) {
        CarColor carColor = this.modelMapperService.forRequest().
                map(createColorRequest, CarColor.class);
        this.carColorRepository.save(carColor);


    }

    @Override
    public void update(UpdateColorRequest updateColorRequest) {
        CarColor carColor = this.modelMapperService.forRequest().
                map(updateColorRequest, CarColor.class);
        this.carColorRepository.save(carColor);


    }
}
