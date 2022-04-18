package com.example.ebshop.service;

import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.response.AuthorDto;
import com.example.ebshop.entity.Author;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

public interface IAuthorService {

    void createAuthor(AuthorCreateForm authorCreateForm);

    void getAuthorByName(String name);

    boolean existsByName(String name);

    AuthorDto getAuthorById(String id);

    void updateAuthor(AuthorCreateForm authorCreateForm) throws EntityNotFoundException;

    void deleteByAuthorId(String id);

}
