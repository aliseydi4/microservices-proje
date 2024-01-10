package org.turkcell.customerservice.business.service;

import org.springframework.stereotype.Service;
import org.turkcell.customerservice.business.responses.CreatCustomerRequest;
import org.turkcell.customerservice.business.responses.CreatedCustomerResponse;
import org.turkcell.customerservice.dataAccess.CustomerRepository;
import org.turkcell.customerservice.entities.Customer;
import org.turkcell.customerservice.entities.Gender;

@Service
public class CustomerManager {
    private final CustomerRepository repository;

    public CustomerManager(CustomerRepository repository) {
        this.repository = repository;
    }
    public CreatedCustomerResponse add(CreatCustomerRequest request){
        Customer customer=new Customer.Builder()
                .name(request.getName())
                .lastName(request.getLastName())
                .TCN(request.getTCN())
                .gender(request.getGender())
                .build();
        customer=repository.save(customer);
        return new CreatedCustomerResponse(customer.getId(), customer.getName());
    }
}
