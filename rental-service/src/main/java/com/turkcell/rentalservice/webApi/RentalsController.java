package com.turkcell.rentalservice.webApi;

import com.turkcell.rentalservice.business.requests.CreateRentalRequest;
import com.turkcell.rentalservice.business.requests.UpdateRentalRequest;
import com.turkcell.rentalservice.business.responses.CreatedRentalResponse;
import com.turkcell.rentalservice.business.responses.GetAllRentalsResponse;
import com.turkcell.rentalservice.business.rules.RentalRule;
import com.turkcell.rentalservice.business.service.RentalManager;
import com.turkcell.rentalservice.entities.Rental;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/rentals")
public class RentalsController {
    private final RentalManager manager;

    public RentalsController(RentalManager manager, RentalRule rentalRule) {
        this.manager = manager;
    }

    @PostMapping("isAvailable")
    public String isAvailable(@RequestParam String code) {
        return manager.isAvailable(code);
    }

    @PostMapping("add")
    public CreatedRentalResponse add(@RequestBody @Valid CreateRentalRequest request) {
        return manager.add(request);
    }

    @PutMapping("update")
    public CreatedRentalResponse update( @RequestBody @Valid UpdateRentalRequest request,@RequestParam String id) {
        return manager.update(id, request);
    }

    @GetMapping("getAll")
    public List<GetAllRentalsResponse> getAll() {
        return manager.getAll();
    }

    @DeleteMapping("delete")
    public void delete(String code) {
        manager.delete(code);

    }
    @PostMapping("price")
    public double price(String id) {
        return manager.price(id);
    }
}
