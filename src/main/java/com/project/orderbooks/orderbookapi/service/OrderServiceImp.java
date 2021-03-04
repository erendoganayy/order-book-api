package com.project.orderbooks.orderbookapi.service;

import com.project.orderbooks.orderbookapi.exception.OrderNotFoundException;
import com.project.orderbooks.orderbookapi.model.entity.Order;
import com.project.orderbooks.orderbookapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {


    private OrderRepository orderRepository;

    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()){
            throw new OrderNotFoundException("order not found with id -->"+id);
        }
        else{
            return order;
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()){
            throw new OrderNotFoundException("order not found with id -->"+id);
        }
        else {
            orderRepository.deleteById(id);
        }
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}
