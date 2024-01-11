package org.turkcell.customerservice.business.rules;

import org.springframework.stereotype.Service;
import org.turkcell.customerservice.core.utilities.exceptions.BusinessException;
import org.turkcell.customerservice.dataAccess.CustomerRepository;
@Service
public class CustomerRule {
    private final CustomerRepository repository;

    public CustomerRule(CustomerRepository repository) {
        this.repository = repository;
    }
    public void checkIfCustomerIdAndTCNExists(String id){
        if (Boolean.FALSE.equals(repository.existsByTCN(id))){
            throw new BusinessException("You entered incorrect information");
        }
    }
}
