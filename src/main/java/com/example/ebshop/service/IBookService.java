package com.example.ebshop.service;

import com.example.ebshop.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBookByStatus();
    Book save(Book book);
    void deleteBookById(String id);
    Book findById(String id);
}
