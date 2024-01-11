package org.turkcell.customerservice.webApi;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedCustomerResponse add(@RequestBody @Valid CreatCustomerRequest request){
        return customerManager.add(request);
    }
    @GetMapping("getAll")
    public List<GetAllCustomerResponse> getAll(){
        return customerManager.getAll();
    }

    @DeleteMapping("delete")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestParam String tcn){
        customerManager.delete(tcn);
    }
    @DeleteMapping("getAllDelete")
    @ResponseStatus(code = HttpStatus.OK)
    public void getAllDelete(String tcn) {
            customerManager.getAllDelete(tcn);
    }
    }
