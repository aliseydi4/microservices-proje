package org.turkcell.customerservice.business.requests;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.turkcell.customerservice.entities.Gender;

import java.math.BigDecimal;

public class UpdateCustomerRequest {
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
    private Gender gender;
    @Min(1)
    private BigDecimal balance;

    public UpdateCustomerRequest() {
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

    public UpdateCustomerRequest(String name, String lastName, String TCN, BigDecimal balance, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.TCN = TCN;
        this.balance = balance;
        this.gender = gender;

    }
}
