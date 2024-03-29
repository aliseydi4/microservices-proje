package com.turkcell.rentalservice.dataAccess;

import com.turkcell.rentalservice.business.responses.GetAllRentalsResponse;
import com.turkcell.rentalservice.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, String> {

    boolean existsByCode(String code);

   Rental  findByCode(String code);

    @Query("select new com.turkcell.rentalservice.business.responses.GetAllRentalsResponse(r.id,r.code,r.customerName,r.startDate,r.endDate,r.rentingPrice)from Rental as r")
    List<GetAllRentalsResponse> getAll();

    void deleteByCode(String code);

    @Query("select r.endDate,r.startDate from Rental as r where r.code=?1")
    Rental daily(String code);


    @Query("select r.rentingPrice from Rental as r where r.id=?1")
    double price(String id);

}
