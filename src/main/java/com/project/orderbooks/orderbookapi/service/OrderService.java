package com.project.orderbooks.orderbookapi.service;

import com.project.orderbooks.orderbookapi.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAllOrders();

    Optional<Order> findOrderById(Long id);

    void deleteOrderById(Long id);

    void createOrder(Order order);

}
