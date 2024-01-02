package com.turkcell.carservice.dataAccess;

import com.turkcell.carservice.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String> {
}
