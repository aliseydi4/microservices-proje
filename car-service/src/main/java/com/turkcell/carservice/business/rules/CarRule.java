package com.turkcell.carservice.business.rules;

import com.turkcell.carservice.dataAccess.CarRepository;

public class CarRule {
    private final CarRepository carRepository;

    public CarRule(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public void checkIfCarCodeExists(String code){
        if (Boolean.TRUE.equals(carRepository.existsByCode(code))){
            throw new RuntimeException();
        }
    }
}
