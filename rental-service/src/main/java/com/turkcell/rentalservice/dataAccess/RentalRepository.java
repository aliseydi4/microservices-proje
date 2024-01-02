package com.turkcell.rentalservice.dataAccess;

import com.turkcell.rentalservice.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental,String> {

    boolean existsByCode(String code);
}
