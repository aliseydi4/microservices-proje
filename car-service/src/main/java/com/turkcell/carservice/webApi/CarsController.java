package com.turkcell.carservice.webApi;

import com.turkcell.carservice.business.requests.CreateCarRequest;
import com.turkcell.carservice.business.requests.UpdateCarRequest;
import com.turkcell.carservice.business.responses.AvailableCarsResponse;
import com.turkcell.carservice.business.responses.CreatedCarResponse;
import com.turkcell.carservice.business.responses.GetAllCarsResponse;
import com.turkcell.carservice.business.responses.UpdateCarResponse;
import com.turkcell.carservice.business.rules.CarRule;
import com.turkcell.carservice.business.service.CarManager;
import com.turkcell.carservice.entities.Car;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/cars")
public class CarsController {
    private final CarManager carManager;
    private final CarRule carRule;


    public CarsController(CarManager carManager, CarRule carRule) {
        this.carManager = carManager;

        this.carRule = carRule;
    }

    @PostMapping("add")
    public CreatedCarResponse add(@RequestBody @Valid CreateCarRequest request) {
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

    @PutMapping("update")
    public UpdateCarResponse update(@RequestBody @Valid UpdateCarRequest request, @RequestParam String id) {
        return carManager.update(request,id);
    }

    @DeleteMapping("delete")
    @ResponseStatus(code = HttpStatus.OK)
    public String delete(@RequestParam String code) {
        return carManager.delete(code);
    }
    @GetMapping("checkIfRentalCodeRule")
    public void checkIfRentalCarCode(String code) {
        carRule.checkIfRentalCarCode(code);
    }
    @GetMapping("dailyPrice")
    public double dailyPrice(String code) {
        return carManager.dailyPrice(code);
    }

    }
