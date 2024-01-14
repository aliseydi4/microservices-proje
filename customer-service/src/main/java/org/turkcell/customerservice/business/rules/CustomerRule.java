package org.turkcell.customerservice.business.rules;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.turkcell.customerservice.core.utilities.exceptions.BusinessException;
import org.turkcell.customerservice.core.utilities.exceptions.IllegalArgumentException;
import org.turkcell.customerservice.dataAccess.CustomerRepository;
import org.turkcell.customerservice.entities.Customer;

import java.math.BigDecimal;

@Service
public class CustomerRule {
    private final CustomerRepository repository;
    private final WebClient.Builder builder;

    public CustomerRule(CustomerRepository repository, WebClient.Builder builder) {
        this.repository = repository;
        this.builder = builder;
    }

    public void checkIfCustomerIdAndTCNExists(String id) {
        if (Boolean.FALSE.equals(repository.existsByTCN(id))) {
            throw new BusinessException("You entered incorrect information");
        }
    }
    @Transactional
    public void balance(double balance,String id){
        BigDecimal currentBalance = repository.balance(id);

        if (balance > currentBalance.doubleValue()) {
            throw new IllegalArgumentException("Balance value cannot be greater than the current balance.");
        }

        BigDecimal newBalance = currentBalance.subtract(BigDecimal.valueOf(balance));
        repository.balance(newBalance, id);
    }

    }

