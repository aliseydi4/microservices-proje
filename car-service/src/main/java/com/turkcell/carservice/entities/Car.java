package com.turkcell.carservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Document(value = "cars")
public class Car {
    @Id
    private String id;
    private String code;
    private String brand;
    private String model;
    private String color;
    private LocalDate years;
    private double dailyPrice;
    private String available;

    public Car() {
    }

    private Car(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.years = builder.years;
        this.dailyPrice = builder.dailyPrice;
        this.available = builder.available;
    }

    public static class Builder {
        private String id;
        private String code;
        private String brand;
        private String model;
        private String color;
        private LocalDate years;
        private double dailyPrice;
        private String available;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder years(LocalDate years) {
            this.years = years;
            return this;
        }

        public Builder dailyPrice(double dailyPrice) {
            this.dailyPrice = dailyPrice;
            return this;
        }

        public Builder available(String available) {
            this.available = available;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
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
