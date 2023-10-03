package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.MaintenanceService;
import com.example.rentcarspringboot2.business.requests.CreateMaintenanceRequest;
import com.example.rentcarspringboot2.business.requests.UpdateMaintenanceRequest;
import com.example.rentcarspringboot2.business.responses.GetAllMaintenanceResponse;
import com.example.rentcarspringboot2.business.responses.GetByIDMaintenanceResponse;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.CarRepository;
import com.example.rentcarspringboot2.dataAccess.abstracts.MaintenanceRepository;
import com.example.rentcarspringboot2.entities.concretes.Car;
import com.example.rentcarspringboot2.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private MaintenanceRepository maintenanceRepository;
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;

    @Override
    public List<GetAllMaintenanceResponse> getAll() {
        List<Maintenance> maintenanceList = maintenanceRepository.findAll();
        List<GetAllMaintenanceResponse> getAll = maintenanceList.stream().map(maintenance -> modelMapperService.forResponse()
                .map(maintenance,GetAllMaintenanceResponse.class)).collect(Collectors.toList());
        return getAll;
    }

    @Transactional
    @Override
    public void add(CreateMaintenanceRequest createMaintenanceRequest) {
        Maintenance maintenance = modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
        Car car =  carRepository.findById(createMaintenanceRequest.getCarId()).orElseThrow();
        car.setState(3);//state => 1- available = true, 2= rented, 3= underMaintenance
        maintenanceRepository.save(maintenance);
    }

    @Transactional
    @Override
    public void update(UpdateMaintenanceRequest updateMaintenanceRequest) {
        Maintenance maintenance = modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);
        Car car = carRepository.findById(updateMaintenanceRequest.getCarId()).orElseThrow();
        car.setState(1);//state => 1- available = true, 2= rented, 3= underMaintenance
        maintenanceRepository.save(maintenance);
    }

    @Override
    public GetByIDMaintenanceResponse getById(int id) {
        Maintenance maintenance = maintenanceRepository.findById(id).orElseThrow();
        GetByIDMaintenanceResponse getById = modelMapperService.forResponse().map(maintenance, GetByIDMaintenanceResponse.class);
        return getById;
    }

    @Override
    public void delete(int id) {
        maintenanceRepository.deleteById(id);
    }
}
