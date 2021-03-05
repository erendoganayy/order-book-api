package com.project.orderbooks.orderbookapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private long bookId;
    private String bookName;
    private int bookPrice;
    private int stock;
    @OneToMany(mappedBy = "book")
    @JsonIgnore
    public List<Order> orderList=new ArrayList<>();




}
