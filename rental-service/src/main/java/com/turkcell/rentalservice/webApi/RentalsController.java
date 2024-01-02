package com.turkcell.rentalservice.webApi;

import com.turkcell.rentalservice.business.service.RentalManager;
import com.turkcell.rentalservice.dataAccess.RentalRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/rentals")
public class RentalsController {
    private final RentalManager manager;

    public RentalsController(RentalManager manager) {
        this.manager = manager;
    }

    @PostMapping ("isAvailable")
    public String isAvailable(@RequestParam String code){
        return manager.isAvailable(code);
    }
}
