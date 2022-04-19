package com.example.ebshop.service;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.response.AuthorDetailDto;
import com.example.ebshop.dto.response.AuthorDto;
import com.example.ebshop.dto.response.BookDTO;
import com.example.ebshop.entity.Author;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface IAuthorService {

    void createAuthor(AuthorCreateForm authorCreateForm) throws ExceptionHandling;

    void getAuthorByName(String name);

    boolean existsByName(String name);

    AuthorDto getAuthorById(String id);

    AuthorDetailDto getAuthorDetailByAuthorId(String id);

    void updateAuthor(AuthorCreateForm authorCreateForm) throws EntityNotFoundException;

    void deleteByAuthorId(String id) throws ExceptionHandling;
//
//    List<BookDTO>  getThreeBestSoldBooksByAuthorId(String id);
//
//    String getBooksByAuthorId(String id);
}
