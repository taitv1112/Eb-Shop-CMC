package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.response.AuthorDto;
import com.example.ebshop.repository.IAuthorRepository;
import com.example.ebshop.repository.IBookRepository;
import com.example.ebshop.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    IAuthorRepository authorRepository;

    @Autowired
    IBookRepository bookRepository;

    @Override
    public void createAuthor(AuthorCreateForm authorCreateForm) {
        if(existsByName(authorCreateForm.getAuthorName())){
        }
        authorRepository.save(authorCreateForm.toEntity());
    }

    @Override
    public void updateAuthor(AuthorCreateForm authorUpdateForm) throws EntityNotFoundException {
        if(getAuthorById(authorUpdateForm.getAuthorId()) == null){
            throw new EntityNotFoundException();
        }
        authorRepository.save(authorUpdateForm.toEntity());
    }



    @Override
    public void deleteByAuthorId(String id) {
        if(getAuthorById(id) == null){
            throw new EntityNotFoundException();
        }
        if(bookRepository.existsBookByAuthor_Id(id)){

        }
    }


    @Override
    public void getAuthorByName(String name) {
        authorRepository.getAuthorByName(name);
    }

    @Override
    public boolean existsByName(String name){
       return authorRepository.existsByName(name);
    }

    @Override
    public AuthorDto getAuthorById( String id) {
        return  authorRepository.getAuthorById(AuthorDto.class, id);
    }

}
