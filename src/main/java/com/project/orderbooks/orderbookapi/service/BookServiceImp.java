package com.project.orderbooks.orderbookapi.service;

import com.project.orderbooks.orderbookapi.exception.BookNotFoundException;
import com.project.orderbooks.orderbookapi.model.entity.Book;
import com.project.orderbooks.orderbookapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{

    private BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()){
            throw new BookNotFoundException("book not found with id -->"+id);
        }
        return book;
    }

    @Override
    public void deleteBookById(Long id) {
        Optional<Book>book = bookRepository.findById(id);
        if (!book.isPresent()){
            throw new BookNotFoundException("book not found with id -->"+id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
