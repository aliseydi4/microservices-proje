package com.turkcell.carservice.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class CreateCarRequest {
    @NotNull
    @NotBlank
    private String code;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String color;
    @Past
    private LocalDate years;
    @Positive
    private double dailyPrice;


    public CreateCarRequest() {
    }

    public CreateCarRequest(String code, String brand, String model, String color, LocalDate years, double dailyPrice) {
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.years = years;
        this.dailyPrice = dailyPrice;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getYears() {
        return years;
    }

    public void setYears(LocalDate years) {
        this.years = years;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }


}
