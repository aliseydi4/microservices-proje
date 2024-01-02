package com.turkcell.rentalservice.business.responses;

import java.time.LocalDate;

public class GetAllRentalsResponse {
    private String id;
    private String code;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;

    public GetAllRentalsResponse() {
    }

    public GetAllRentalsResponse(String id, String code, String customerName, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.code = code;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
