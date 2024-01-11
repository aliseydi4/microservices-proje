package org.turkcell.customerservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.turkcell.customerservice.business.responses.GetAllCustomerResponse;
import org.turkcell.customerservice.entities.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("select new org.turkcell.customerservice.business.responses.GetAllCustomerResponse" +
            "(c.id,c.name,c.lastName,c.TCN,c.balance,c.gender)from Customer as c")
   List<GetAllCustomerResponse> getCustomer();

    @Query("select new org.turkcell.customerservice.business.responses.GetAllCustomerResponse" +
            "(c.id,c.name,c.lastName,c.TCN,c.balance,c.gender)from Customer as c where c.id=?1 or c.TCN=?1")
    List<GetAllCustomerResponse> getByCodeCustomer(String id);

    void deleteByTCN(String tcn);
    boolean existsByTCN(String tcn);
}
