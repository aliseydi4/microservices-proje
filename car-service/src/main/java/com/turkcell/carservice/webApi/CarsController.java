package com.turkcell.carservice.webApi;

import com.turkcell.carservice.business.requests.CreateCarRequest;
import com.turkcell.carservice.business.responses.CreatedCarResponse;
import com.turkcell.carservice.business.service.CarManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/cars")
public class CarsController {
    private final CarManager carManager;

    public CarsController(CarManager carManager) {
        this.carManager = carManager;
    }
    @PostMapping("add")
    public CreatedCarResponse add(@RequestBody CreateCarRequest request){
        return carManager.add(request);
    }
}
