package com.project.orderbooks.orderbookapi.controller;

import com.project.orderbooks.orderbookapi.model.entity.Book;
import com.project.orderbooks.orderbookapi.service.BookServiceImp;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BookControlller {

    private BookServiceImp bookServiceImp;

    public BookControlller(BookServiceImp bookServiceImp) {
        this.bookServiceImp = bookServiceImp;
    }

    @GetMapping("/books")
    public List<Book> retrieveAllBooks(){
        return bookServiceImp.findAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> retrieveBookById(@PathVariable("id") long id){
        Optional<Book> book=bookServiceImp.findBookById(id);
        return book;
    }

    @PostMapping("/books")
    public void createBook(@Valid @RequestBody Book book){
        bookServiceImp.createBook(book);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id){
        bookServiceImp.deleteBookById(id);
    }
}
