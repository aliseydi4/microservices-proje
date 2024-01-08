package com.turkcell.rentalservice.business.rules;

import com.turkcell.rentalservice.core.utilities.exception.BusinessException;
import com.turkcell.rentalservice.dataAccess.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

    public Double rentingPrice(String code) {
        Double clients;
        clients = builder.build().get().uri("http://car-service/v1/api/cars/dailyPrice", (uriBuilder -> uriBuilder
                        .queryParam("code", code).build()))
                .retrieve()
                .bodyToMono(Double.class)
                .block();
        return clients;
    }

}
