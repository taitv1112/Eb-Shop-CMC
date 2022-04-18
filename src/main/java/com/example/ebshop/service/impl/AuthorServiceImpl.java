package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.AuthorDTO;
import com.example.ebshop.entity.Author;
import com.example.ebshop.repository.AuthorRepository;
import com.example.ebshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public ResponseEntity<String> saveAuthor(AuthorDTO authorDTO) {
        if (ObjectUtils.isEmpty(authorDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body("Author is null!");
        }
        Author author = transferData(authorDTO);
        authorRepository.save(author);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }

    @Override
    public ResponseEntity<?> getAuthorById(String id) {
        if(ObjectUtils.isEmpty(authorRepository.findById(id))) return ResponseEntity.status(HttpStatus.OK).body("Author is not exist!");
        return new ResponseEntity<>(authorRepository.findById(id).get(),HttpStatus.OK);
    }

    private Author transferData(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        return author;
    }
}
