package com.project.orderbooks.orderbookapi.controller;

import com.project.orderbooks.orderbookapi.exception.OrderNotFoundException;
import com.project.orderbooks.orderbookapi.model.entity.Order;
import com.project.orderbooks.orderbookapi.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<Order> retrieveOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> retrieveOrderById(@PathVariable long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()){
            throw new OrderNotFoundException("order not found with id -->"+id);
        }
        else{
            return optionalOrder;
        }
    }

    @PostMapping("/orders")
    public void createOrder(){
        /**
         ** create a order
         * */
    }

}
