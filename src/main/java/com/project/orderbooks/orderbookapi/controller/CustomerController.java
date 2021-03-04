package com.project.orderbooks.orderbookapi.controller;

import com.project.orderbooks.orderbookapi.model.entity.Customer;
import com.project.orderbooks.orderbookapi.service.CustomerServiceImp;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerServiceImp customerServiceImp;
    public CustomerController(CustomerServiceImp customerServiceImp) {
        this.customerServiceImp=customerServiceImp;
    }

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers(){
        return customerServiceImp.findAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> retrieveById(@PathVariable("id") long id){
        Optional<Customer> customer=customerServiceImp.findCustomerById(id);
        return customer;
    }


    @PostMapping("/customers")
    public void createCustomer(@Valid @RequestBody Customer customer){
    customerServiceImp.createCustomer(customer);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerServiceImp.deleteCustomerById(id);

    }

}
