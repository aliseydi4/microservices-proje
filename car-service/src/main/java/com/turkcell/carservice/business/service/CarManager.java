package com.turkcell.carservice.business.service;

import com.turkcell.carservice.business.requests.CreateCarRequest;
import com.turkcell.carservice.business.responses.CreatedCarResponse;
import com.turkcell.carservice.dataAccess.CarRepository;
import com.turkcell.carservice.entities.Car;
import org.springframework.stereotype.Service;

@Service
public class CarManager {
    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CreatedCarResponse add(CreateCarRequest request){
        Car car=new Car.Builder().code(request.getCode())
                .brand(request.getBrand())
                .model(request.getModel())
                .color(request.getColor())
                .years(request.getYears())
                .dailyPrice(request.getDailyPrice())
                .available(request.isAvailable())
                .build();
        carRepository.save(car);
        return new CreatedCarResponse(car.getId(), car.getCode());
    }
}
