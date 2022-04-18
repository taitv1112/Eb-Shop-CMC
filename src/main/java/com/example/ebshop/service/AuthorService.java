package com.example.ebshop.service;

import com.example.ebshop.dto.request.AuthorDTO;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    ResponseEntity<String> saveAuthor(AuthorDTO author);
    ResponseEntity<?> getAuthorById(String id);
    ResponseEntity<String> updateAuthor(AuthorDTO authorDTO);
    ResponseEntity<String> deleteAuthor(String id);
}
