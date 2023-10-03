package com.example.rentcarspringboot2.business.concretes;

import com.example.rentcarspringboot2.business.abstracts.CreditCardService;
import com.example.rentcarspringboot2.business.abstracts.RentalService;
import com.example.rentcarspringboot2.business.requests.CreateRentalRequest;
import com.example.rentcarspringboot2.business.requests.UpdateRentalRequest;
import com.example.rentcarspringboot2.business.responses.GetAllRentalResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdBrandsResponse;
import com.example.rentcarspringboot2.business.responses.GetByIdRentalResponse;
import com.example.rentcarspringboot2.business.rules.RentalBusinessRules;
import com.example.rentcarspringboot2.core.utilities.mappers.ModelMapperService;
import com.example.rentcarspringboot2.dataAccess.abstracts.PaymentRepository;
import com.example.rentcarspringboot2.dataAccess.abstracts.RentalRepository;
import com.example.rentcarspringboot2.entities.concretes.Rentals;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private ModelMapperService modelMapperService;
    private PaymentRepository paymentRepository;
    private CreditCardService creditCardService;
    private RentalBusinessRules businessRules;

    @Override
    public List<GetAllRentalResponse> getAll() {
        List<Rentals> rentals = rentalRepository.findAll();
        List<GetAllRentalResponse> rentalsResponses = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetAllRentalResponse.class))
                .collect(Collectors.toList());
        return rentalsResponses;
    }

    @Override
    public void add(CreateRentalRequest createRentalRequest) {
        if(businessRules.checkIfCarAvaible(createRentalRequest.getCarId())){
            Rentals rentals = modelMapperService.forRequest().map(createRentalRequest, Rentals.class);
            rentalRepository.save(rentals);

        }

    }

    @Override
    public GetByIdRentalResponse getById(int id) {
        Rentals rentals = rentalRepository.findById(id).orElseThrow();
        GetByIdRentalResponse  getByIdRentalResponse= modelMapperService.forResponse().map(rentals, GetByIdRentalResponse.class);
        return getByIdRentalResponse;
    }

    @Override
    public void delete(int id) {
        rentalRepository.deleteById(id);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
            Rentals rentals = modelMapperService.forRequest().map(updateRentalRequest, Rentals.class);
            rentalRepository.save(rentals);

    }
}
