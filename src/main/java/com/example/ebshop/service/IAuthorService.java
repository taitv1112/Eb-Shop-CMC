package com.example.ebshop.service;

import com.example.ebshop.dto.AuthorDetail;
import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    Author save(Author author);
    void delete(String id);
    Author findById(String id);
    AuthorDetail findAuthorDetail(String id);
}
