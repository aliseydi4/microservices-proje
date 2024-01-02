package com.turkcell.carservice.business.responses;

import java.time.LocalDate;

public class AvailableCarsResponse {
    private String id;
    private String code;
    private String brand;
    private String model;
    private String color;
    private LocalDate years;
    private double dailyPrice;
    private String available;

    public AvailableCarsResponse() {
    }

    public AvailableCarsResponse(String id, String code, String brand, String model, String color, LocalDate years, double dailyPrice, String available) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.years = years;
        this.dailyPrice = dailyPrice;
        this.available = available;
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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
