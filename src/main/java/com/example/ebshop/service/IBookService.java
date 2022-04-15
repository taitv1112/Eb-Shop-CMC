package com.example.ebshop.service;

import com.example.ebshop.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book save(Book book);
    void delete(String id);
    Book findById(String id);
}
