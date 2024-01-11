package org.turkcell.customerservice.business.service;

import org.springframework.stereotype.Service;
import org.turkcell.customerservice.business.requests.CreatCustomerRequest;
import org.turkcell.customerservice.business.responses.CreatedCustomerResponse;
import org.turkcell.customerservice.business.responses.GetAllCustomerResponse;
import org.turkcell.customerservice.dataAccess.CustomerRepository;
import org.turkcell.customerservice.entities.Customer;

import java.util.List;

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
                .balance(request.getBalance())
                .build();
        customer=repository.save(customer);
        return new CreatedCustomerResponse(customer.getId(), customer.getName());
    }
    public List<GetAllCustomerResponse> getAll(){
        return repository.getCustomer();
    }
}
