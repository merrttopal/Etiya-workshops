package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.CarService;
import com.example.rentcarspringboot2.business.requests.CreateCarRequest;
import com.example.rentcarspringboot2.business.requests.UpdateCarRequest;
import com.example.rentcarspringboot2.business.responses.GetAllCarsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdCarsResponse;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.CarRepository;
import com.example.rentcarspringboot2.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
        return carsResponse;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest()
                .map(createCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest()
                .map(updateCarRequest, Car.class);
        this.carRepository.save(car);
    }

    @Override
    public GetByIdCarsResponse getById(int id) {
        Car car = this.carRepository.findById(id).orElseThrow();
        GetByIdCarsResponse response = this.modelMapperService.forResponse()
                .map(car, GetByIdCarsResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);
    }
}
