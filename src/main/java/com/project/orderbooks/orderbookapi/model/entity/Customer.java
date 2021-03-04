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
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private long customer_id;
    private String customer_name;
    private String customer_email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList=new ArrayList<>();
}
