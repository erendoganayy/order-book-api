package com.project.orderbooks.orderbookapi.service;

import com.project.orderbooks.orderbookapi.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();

    Optional<Book> findBookById(Long id);

    void deleteBookById(Long id);

    void createBook(Book book);


}
