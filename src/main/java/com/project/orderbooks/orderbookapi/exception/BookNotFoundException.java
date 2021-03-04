package com.project.orderbooks.orderbookapi.exception;

import com.project.orderbooks.orderbookapi.model.entity.Book;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}