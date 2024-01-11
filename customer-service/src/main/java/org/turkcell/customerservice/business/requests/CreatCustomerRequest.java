package org.turkcell.customerservice.business.requests;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.turkcell.customerservice.entities.Gender;

import java.math.BigDecimal;

public class CreatCustomerRequest {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$",message = "invalid TCN :")
    private String TCN;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal balance;

    public CreatCustomerRequest() {
    }

    public CreatCustomerRequest(String name, String lastName, String TCN, Gender gender, BigDecimal balance) {
        this.name = name;
        this.lastName = lastName;
        this.TCN = TCN;
        this.gender = gender;
        this.balance=balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
