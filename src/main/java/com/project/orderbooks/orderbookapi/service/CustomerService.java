package com.project.orderbooks.orderbookapi.service;


import com.project.orderbooks.orderbookapi.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

     List<Customer> findAllCustomers();

     Optional<Customer> findCustomerById(Long id);

     void deleteCustomerById(Long id);

     void createCustomer(Customer customer);






}
