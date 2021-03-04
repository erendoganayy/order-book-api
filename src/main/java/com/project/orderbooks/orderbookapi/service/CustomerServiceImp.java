package com.project.orderbooks.orderbookapi.service;

import com.project.orderbooks.orderbookapi.exception.CustomerNotFoundException;
import com.project.orderbooks.orderbookapi.model.entity.Customer;
import com.project.orderbooks.orderbookapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{
    private CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        Optional<Customer> customer= customerRepository.findById(id);
        if (!customer.isPresent()){
            throw new CustomerNotFoundException("customer not found with id -->" + id);
        }
        else {
            return customer;
        }
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
