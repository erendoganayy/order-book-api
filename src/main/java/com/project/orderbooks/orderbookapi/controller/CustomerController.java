package com.project.orderbooks.orderbookapi.controller;

import com.project.orderbooks.orderbookapi.exception.CustomerNotFoundException;
import com.project.orderbooks.orderbookapi.exception.OrderNotFoundException;
import com.project.orderbooks.orderbookapi.model.entity.Customer;
import com.project.orderbooks.orderbookapi.model.entity.Order;
import com.project.orderbooks.orderbookapi.repository.CustomerRepository;
import com.project.orderbooks.orderbookapi.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    public CustomerController(CustomerRepository customerRepository,OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> retrieveById(@PathVariable("id") long id){
        Optional<Customer> customer=customerRepository.findById(id);
        if (customer.isEmpty()){
            throw new CustomerNotFoundException("customer not found with id -->"+id);
        }
        else{
            return customer;
        }
    }


    @PostMapping("/customers")
    public void createCustomer(@Valid @RequestBody Customer customer){
                /**
                    * add a book
                *  */    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerRepository.deleteById(id);
    }

}
