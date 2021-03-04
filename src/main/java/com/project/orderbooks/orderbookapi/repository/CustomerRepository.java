package com.project.orderbooks.orderbookapi.repository;

import com.project.orderbooks.orderbookapi.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
