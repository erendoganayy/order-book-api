package com.project.orderbooks.orderbookapi.controller;

import com.project.orderbooks.orderbookapi.exception.BookNotFoundException;
import com.project.orderbooks.orderbookapi.model.entity.Book;
import com.project.orderbooks.orderbookapi.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookControlller {
    private BookRepository bookRepository;

    public BookControlller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> retrieveAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> retrieveBookById(@PathVariable("id") long id){
        Optional<Book> optionalBook=bookRepository.findById(id);
        if (optionalBook.isEmpty()){
            throw new BookNotFoundException("book not found by id --> "+id);
        }
        else{
            return optionalBook;
        }
    }

    @PostMapping("/books")
    public void createBook(){
        /**
         * add a book
         * */

    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id){
        bookRepository.deleteById(id);
    }
}
