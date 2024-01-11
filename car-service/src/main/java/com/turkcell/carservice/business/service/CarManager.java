package com.turkcell.carservice.business.service;

import com.turkcell.carservice.business.requests.CreateCarRequest;
import com.turkcell.carservice.business.requests.UpdateCarRequest;
import com.turkcell.carservice.business.responses.AvailableCarsResponse;
import com.turkcell.carservice.business.responses.CreatedCarResponse;
import com.turkcell.carservice.business.responses.GetAllCarsResponse;
import com.turkcell.carservice.business.responses.UpdateCarResponse;
import com.turkcell.carservice.business.rules.CarRule;
import com.turkcell.carservice.core.utilities.exception.BusinessException;
import com.turkcell.carservice.dataAccess.CarRepository;
import com.turkcell.carservice.entities.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager {
    private final CarRepository carRepository;
    private final WebClient.Builder builder;
    private final CarRule carRule;

    public CarManager(CarRepository carRepository, WebClient.Builder builder, CarRule carRule) {
        this.carRepository = carRepository;
        this.builder = builder;
        this.carRule = carRule;
    }

    public CreatedCarResponse add(CreateCarRequest request) {
        Car car = new Car.Builder().code(request.getCode())
                .brand(request.getBrand())
                .model(request.getModel())
                .color(request.getColor())
                .years(request.getYears())
                .dailyPrice(request.getDailyPrice())
                .build();
        carRepository.save(car);
        return new CreatedCarResponse(car.getId(), car.getCode());
    }

    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = carRepository.findAll();
        List<GetAllCarsResponse> responseList = new ArrayList<>();
        for (Car car : cars) {
            GetAllCarsResponse response = new GetAllCarsResponse(car.getId(), car.getCode(), car.getBrand(), car.getModel(), car.getColor(), car.getYears(), car.getDailyPrice());
            responseList.add(response);
        }

        return responseList;
    }

    public AvailableCarsResponse isAvailableCars(String code) {
        String webClient = builder.build().post().uri("http://rental-service/v1/api/rentals/isAvailable", (uriBuilder -> uriBuilder
                        .queryParam("code", code).build()))
                .retrieve().bodyToMono(String.class).block();
        Car car = carRepository.findByCode(code).orElseThrow(() -> new BusinessException("not found code : " + code));
        return new AvailableCarsResponse(car.getId(), car.getCode(), car.getBrand(), car.getModel(), car.getColor(), car.getYears(), car.getDailyPrice(), webClient);
    }

    public UpdateCarResponse update(UpdateCarRequest request, String id) {
        Car car = new Car.Builder()
                .id(id)
                .brand(request.getBrand())
                .code(request.getCode())
                .model(request.getModel())
                .color(request.getColor())
                .years(request.getYears())
                .dailyPrice(request.getDailyPrice())
                .build();

        car = carRepository.save(car);
        return new UpdateCarResponse(car.getId(), car.getCode());
    }
    @Transactional
    public String delete(String code) {
        carRule.checkIfRentalCarCode(code);
        carRepository.deleteByCode(code);
        return code;
    }
    public double dailyPrice(String code){
        Car car=carRepository.findByCode(code).orElseThrow();
        return car.getDailyPrice();
    }

}
