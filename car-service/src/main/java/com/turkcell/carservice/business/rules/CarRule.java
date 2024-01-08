package com.turkcell.carservice.business.rules;

import com.turkcell.carservice.core.utilities.exception.BusinessException;
import com.turkcell.carservice.dataAccess.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarRule {
    private final CarRepository carRepository;

    public CarRule(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public void checkIfCarCodeExists(String code){
        if (Boolean.TRUE.equals(carRepository.existsByCode(code))){
            throw new BusinessException("This code cannot be entered ");
        }
    }
    public void checkIfRentalCarCode(String code){
        if (Boolean.FALSE.equals(carRepository.existsByCode(code))){
             throw new BusinessException("not found code :"+code);
        }
    }
}
