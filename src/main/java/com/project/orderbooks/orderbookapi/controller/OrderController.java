package com.project.orderbooks.orderbookapi.controller;

import com.project.orderbooks.orderbookapi.model.entity.Order;
import com.project.orderbooks.orderbookapi.service.OrderServiceImp;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private OrderServiceImp orderServiceImp;

    @GetMapping("/orders")
    public List<Order> retrieveOrders(){
        return orderServiceImp.findAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> retrieveOrderById(@PathVariable long id){
        Optional<Order> optionalOrder = orderServiceImp.findOrderById(id);
        return optionalOrder;

    }

    @PostMapping("/orders")
    public void createOrder(@Valid @RequestBody Order order){
        orderServiceImp.createOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable long id){
        orderServiceImp.deleteOrderById(id);
    }

}
