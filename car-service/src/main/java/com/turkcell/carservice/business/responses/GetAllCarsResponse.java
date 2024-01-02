package com.turkcell.carservice.business.responses;

import java.time.LocalDate;

public class GetAllCarsResponse {
    private String id;
    private String code;
    private String brand;
    private String model;
    private String color;
    private LocalDate years;
    private double dailyPrice;


    public GetAllCarsResponse() {
    }

    public GetAllCarsResponse(String id, String code, String brand, String model, String color, LocalDate years, double dailyPrice) {
        this.code = code;
        this.id=id;

        this.brand = brand;
        this.model = model;
        this.color = color;
        this.years = years;
        this.dailyPrice = dailyPrice;
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
