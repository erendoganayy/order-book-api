package com.project.orderbooks.orderbookapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long book_id;

    private String book_name;
    private int book_price;

    @OneToMany(mappedBy = "book")
    private List<Order> orderList=new ArrayList<>();
}
