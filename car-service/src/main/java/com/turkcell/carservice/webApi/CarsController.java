package com.turkcell.carservice.webApi;

import com.turkcell.carservice.business.requests.CreateCarRequest;
import com.turkcell.carservice.business.responses.AvailableCarsResponse;
import com.turkcell.carservice.business.responses.CreatedCarResponse;
import com.turkcell.carservice.business.responses.GetAllCarsResponse;
import com.turkcell.carservice.business.service.CarManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/cars")
public class CarsController {
    private final CarManager carManager;


    public CarsController(CarManager carManager) {
        this.carManager = carManager;

    }

    @PostMapping("add")
    public CreatedCarResponse add(@RequestBody CreateCarRequest request) {
        return carManager.add(request);
    }

    @GetMapping("getAll")
    public List<GetAllCarsResponse> getAll() {

        return carManager.getAll();
    }

    @GetMapping("isAvailable")
    public AvailableCarsResponse isAvailableCars(@RequestParam String code) {
            return carManager.isAvailableCars(code);
    }
    }
