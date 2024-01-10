package org.turkcell.customerservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turkcell.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
