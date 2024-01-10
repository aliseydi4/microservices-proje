package org.turkcell.customerservice.webApi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.turkcell.customerservice.business.responses.CreatCustomerRequest;
import org.turkcell.customerservice.business.responses.CreatedCustomerResponse;
import org.turkcell.customerservice.business.service.CustomerManager;

@RestController
@RequestMapping("customers")
public class CustomersController {
    private final CustomerManager customerManager;

    public CustomersController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }
    @PostMapping("add")
    public CreatedCustomerResponse add(@RequestBody @Valid CreatCustomerRequest request){
        return customerManager.add(request);
    }
}
