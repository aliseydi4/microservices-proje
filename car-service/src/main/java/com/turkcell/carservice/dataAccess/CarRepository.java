package com.turkcell.carservice.dataAccess;

import com.turkcell.carservice.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CarRepository extends MongoRepository<Car,String> {
    Optional<Car>findByCode(String code);
    boolean existsByCode(String code);
    void deleteByCode(String code);
}
