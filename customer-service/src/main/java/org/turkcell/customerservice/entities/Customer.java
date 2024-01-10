package org.turkcell.customerservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "TCKN")
    private int TCN;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;


    public Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.TCN = builder.TCN;
        this.gender = builder.gender;

    }

    public static class Builder {
        private String id;
        private String name;
        private String lastName;
        private int TCN;
        @Enumerated(EnumType.STRING)
        private Gender gender;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder TCN(int TCN) {
            this.TCN = TCN;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
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
