package com.turkcell.rentalservice.business.requests;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateRentalRequest {
    @NotNull
    @NotBlank
    private String code;
    @NotNull
    @NotEmpty
    private String customerName;
    @FutureOrPresent
    private LocalDate startDate;
    @Future
    private LocalDate endDate;

    public CreateRentalRequest() {
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
