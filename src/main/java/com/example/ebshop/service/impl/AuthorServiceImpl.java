package com.example.ebshop.service.impl;

import com.example.ebshop.dto.AuthorDetail;
import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Book;
import com.example.ebshop.exception.ApiRequestException;
import com.example.ebshop.repository.AuthorRepository;
import com.example.ebshop.repository.BookRepository;
import com.example.ebshop.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(String id) {
        if (bookRepository.findAllBookByAuthorId(id).isEmpty()){
            authorRepository.deleteById(id);
        }else {
            throw new ApiRequestException("Tác giả này vẫn còn sách trong hệ thống");
        }
    }

    @Override
    public Author findById(String id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public AuthorDetail findAuthorDetail(String id) {
        return null;
    }


}
