package com.turkcell.rentalservice.business.requests;

import java.time.LocalDate;

public class CreateRentalRequest {
    private String code;
    private String customerName;
    private LocalDate startDate;
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
