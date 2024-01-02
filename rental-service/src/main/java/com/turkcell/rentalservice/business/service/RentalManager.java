package com.turkcell.rentalservice.business.service;

import com.turkcell.rentalservice.dataAccess.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
}
