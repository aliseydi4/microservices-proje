package org.turkcell.customerservice.business.responses;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.turkcell.customerservice.entities.Gender;

import java.math.BigDecimal;

public class GetAllCustomerResponse {
    private String id;
    private String name;
    private String lastName;
    private String TCN;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public GetAllCustomerResponse() {
    }

    public GetAllCustomerResponse(String id, String name, String lastName, String TCN, BigDecimal balance, Gender gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.TCN = TCN;
        this.balance = balance;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTCN() {
        return TCN;
    }

    public void setTCN(String TCN) {
        this.TCN = TCN;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
