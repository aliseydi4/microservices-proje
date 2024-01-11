package org.turkcell.customerservice.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

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
    @Column(name = "identification_number")
    private String TCN;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "balance")
    private BigDecimal balance;


    public Customer() {
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.TCN = builder.TCN;
        this.gender = builder.gender;
        this.balance=builder.balance;

    }

    public static class Builder {
        private String id;
        private String name;
        private String lastName;
        private String TCN;
        private BigDecimal balance;
        @Enumerated(EnumType.STRING)
        private Gender gender;

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

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

        public Builder TCN(String TCN) {
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

    public String getTCN() {
        return TCN;
    }

    public void setTCN (String TCN) {
        this.TCN = TCN;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


}
