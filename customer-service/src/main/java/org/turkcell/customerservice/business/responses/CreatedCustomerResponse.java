package org.turkcell.customerservice.business.responses;

import org.turkcell.customerservice.entities.Gender;

public class CreatedCustomerResponse {
    private String id;
    private String name;

    public CreatedCustomerResponse() {
    }

    public CreatedCustomerResponse(String id, String name) {
        this.id = id;
        this.name = name;
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
}
