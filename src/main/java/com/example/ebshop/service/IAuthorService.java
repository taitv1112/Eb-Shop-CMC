package com.example.ebshop.service;

import com.example.ebshop.dto.AuthorDetailDTO;
import com.example.ebshop.entity.Author;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    Author save(Author author);
    void delete(String id);
    Author findById(String id);

    AuthorDetailDTO findAuthorByID(String id);
}
