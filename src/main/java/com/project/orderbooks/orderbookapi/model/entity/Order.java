package com.project.orderbooks.orderbookapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long orderId;
    private long customerId;
    private double totalPrice;
    private String orderDate;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Book book;







}
