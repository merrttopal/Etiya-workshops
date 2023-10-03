package com.example.rentcarspringboot2.business.abstracts;

import com.example.rentcarspringboot2.business.requests.CreateMaintenanceRequest;
import com.example.rentcarspringboot2.business.requests.UpdateMaintenanceRequest;
import com.example.rentcarspringboot2.business.responses.GetAllMaintenanceResponse;
import com.example.rentcarspringboot2.business.responses.GetByIDMaintenanceResponse;
import com.example.rentcarspringboot2.entities.concretes.Maintenance;

import java.util.List;

public interface MaintenanceService {

   List<GetAllMaintenanceResponse> getAll();
   void add(CreateMaintenanceRequest createMaintenanceRequest);
   void delete(int id);
   void update(UpdateMaintenanceRequest updateMaintenanceRequest);
   GetByIDMaintenanceResponse getById(int id);


}
