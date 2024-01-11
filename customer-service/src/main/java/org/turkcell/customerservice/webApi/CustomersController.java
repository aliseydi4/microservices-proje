package org.turkcell.customerservice.webApi;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.turkcell.customerservice.business.requests.CreatCustomerRequest;
import org.turkcell.customerservice.business.responses.CreatedCustomerResponse;
import org.turkcell.customerservice.business.responses.GetAllCustomerResponse;
import org.turkcell.customerservice.business.service.CustomerManager;

import java.util.List;

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
    @GetMapping("getAll")
    public List<GetAllCustomerResponse> getAll(){
        return customerManager.getAll();
    }
}
