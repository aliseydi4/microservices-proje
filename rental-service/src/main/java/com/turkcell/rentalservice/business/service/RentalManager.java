package com.turkcell.rentalservice.business.service;

import com.turkcell.rentalservice.business.requests.CreateRentalRequest;
import com.turkcell.rentalservice.business.requests.UpdateRentalRequest;
import com.turkcell.rentalservice.business.responses.CreatedRentalResponse;
import com.turkcell.rentalservice.business.responses.GetAllRentalsResponse;
import com.turkcell.rentalservice.dataAccess.RentalRepository;
import com.turkcell.rentalservice.entities.Rental;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class RentalManager {
    private final RentalRepository repository;

    public RentalManager(RentalRepository repository) {
        this.repository = repository;
    }

    public String isAvailable(String code){
        boolean rental=repository.existsByCode(code);
        if (Boolean.TRUE.equals(rental)){

            return ("not available for rent");
        }else {

            return ("available for rent");
        }
    }
    public CreatedRentalResponse add(CreateRentalRequest request){
        Rental rental=new Rental.Builder()
                .code(request.getCode())
                .customerName(request.getCustomerName())
                .startDate(LocalDate.now())
                .endDate(request.getEndDate()).build();
        rental=repository.save(rental);
        return new CreatedRentalResponse(rental.getId(),rental.getCode());
    }
    public CreatedRentalResponse update(String id, UpdateRentalRequest request){
        Rental rental=new Rental.Builder()
                .id(id)
                .code(request.getCode())
                .customerName(request.getCustomerName())
                .startDate(LocalDate.now())
                .endDate(request.getEndDate()).build();
        rental=repository.save(rental);
        return new CreatedRentalResponse(rental.getId(),rental.getCode());
    }
    public List<GetAllRentalsResponse> getAll(){
        return repository.getAll();
    }
    public String delete(String code){
       List <Rental> rental=repository.findByCode(code).orElseThrow();
        repository.deleteAll(rental);
        return code;
    }

}
