package com.example.ebshop.service.impl;

import com.example.ebshop.entity.Book;
import com.example.ebshop.repository.BookRepository;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
       return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).get();
    }
}
