package com.turkcell.carservice.business.service;

import com.turkcell.carservice.business.requests.CreateCarRequest;
import com.turkcell.carservice.business.responses.AvailableCarsResponse;
import com.turkcell.carservice.business.responses.CreatedCarResponse;
import com.turkcell.carservice.business.responses.GetAllCarsResponse;
import com.turkcell.carservice.dataAccess.CarRepository;
import com.turkcell.carservice.entities.Car;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager {
    private final CarRepository carRepository;
    private final WebClient.Builder builder;

    public CarManager(CarRepository carRepository, WebClient.Builder builder) {
        this.carRepository = carRepository;
        this.builder = builder;
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
        String webClient = builder.build().post().uri("http://localhost:8899/v1/api/rentals/isAvailable", (uriBuilder -> uriBuilder
                        .queryParam("code", code).build()))
                .retrieve().bodyToMono(String.class).block();
        Car car = carRepository.findByCode(code).orElseThrow(() -> new RuntimeException("not found code : " + code));
        return new AvailableCarsResponse(car.getId(), car.getCode(), car.getBrand(), car.getModel(), car.getColor(), car.getYears(), car.getDailyPrice(), webClient);
    }
}
