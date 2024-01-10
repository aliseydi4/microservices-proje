package org.turkcell.customerservice.business.responses;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.turkcell.customerservice.entities.Gender;

public class CreatCustomerRequest {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    private int TCN;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public CreatCustomerRequest() {
    }

    public CreatCustomerRequest(String name, String lastName, int TCN, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.TCN = TCN;
        this.gender = gender;
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

    public int getTCN() {
        return TCN;
    }

    public void setTCN(int TCN) {
        this.TCN = TCN;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
