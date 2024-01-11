package com.turkcell.rentalservice.business.rules;

import com.turkcell.rentalservice.core.utilities.exception.BusinessException;
import com.turkcell.rentalservice.dataAccess.RentalRepository;
import com.turkcell.rentalservice.entities.Rental;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.Period;

@Service
public class RentalRule {
    private final RentalRepository repository;
    private final WebClient.Builder builder;

    public RentalRule(RentalRepository repository, WebClient.Builder builder) {
        this.repository = repository;
        this.builder = builder;
    }

    public void checkIfCarCode(String code) {
        builder.build().get().uri("http://car-service/v1/api/cars/checkIfRentalCodeRule", (uriBuilder -> uriBuilder.
                        queryParam("code", code).build()))
                .retrieve().
                bodyToMono(Void.class).block();

    }

    public void checkIfRentalCode(String code) {
        if (Boolean.TRUE.equals(repository.existsByCode(code))) {
            throw new BusinessException("not available");
        }
    }
    public void checkIfNotCode(String code){
        if (Boolean.FALSE.equals(repository.existsByCode(code))){
            throw new BusinessException("code not found "+ code);
        }
    }

    public Double rentingPrice(String code) {
        Double daily;
        Double clients;
        clients = builder.build().get().uri("http://car-service/v1/api/cars/dailyPrice", (uriBuilder -> uriBuilder
                        .queryParam("code", code).build()))
                .retrieve()
                .bodyToMono(Double.class)
                .block();
        daily=betweenDailyPrice(code);
        return clients*daily;
    }

    public double betweenDailyPrice(String code) {
        Rental rental = repository.findByCode(code);
        LocalDate start = rental.getStartDate();
        LocalDate end = rental.getEndDate();
        return Period.between(start, end).getDays();
    }

}
