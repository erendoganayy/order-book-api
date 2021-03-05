package com.project.orderbooks.orderbookapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class OrderDetail {

    private long bookId;
    private double price;

}
