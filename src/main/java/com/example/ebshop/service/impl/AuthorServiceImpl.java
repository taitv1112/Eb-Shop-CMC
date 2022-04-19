package com.example.ebshop.service.impl;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.response.AuthorDetailDto;
import com.example.ebshop.dto.response.AuthorDto;
import com.example.ebshop.dto.response.BookDTO;
import com.example.ebshop.repository.IAuthorRepository;
import com.example.ebshop.repository.IBookRepository;
import com.example.ebshop.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    IAuthorRepository authorRepository;

    @Autowired
    IBookRepository bookRepository;

    @Override
    public void createAuthor(AuthorCreateForm authorCreateForm) throws ExceptionHandling {
        if(existsByName(authorCreateForm.getAuthorName())){
            throw new ExceptionHandling("Tác giả đã tồn tại!");
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
    public void deleteByAuthorId(String id) throws ExceptionHandling {
        if(getAuthorById(id) == null){
            throw new EntityNotFoundException();
        }
        if(bookRepository.existsBookByAuthor_IdAndStatusContains(id,"1")){
            throw new ExceptionHandling("Tác giả vẩn còn sách trong kho. Không được xóa!");
        }

        authorRepository.deleteById(id);
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

    @Override
    public AuthorDetailDto getAuthorDetailByAuthorId(String id) {
        return new AuthorDetailDto(authorRepository.getAuthorById(AuthorDto.class, id).getName(),
                                    bookRepository.countBooksByAuthor_Id(id),
                                    bookRepository.getThreeBestSoldBooksByAuthorId(id));
    }




}
