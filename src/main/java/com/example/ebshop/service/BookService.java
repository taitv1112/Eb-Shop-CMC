package com.example.ebshop.service;

import com.example.ebshop.dto.request.AuthorDTO;
import com.example.ebshop.dto.request.SavedBookDTO;
import com.example.ebshop.dto.response.ThreeMostSellBookDTO;
import com.example.ebshop.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    Book findBookById(String id);
    ResponseEntity<String> saveBookToStorage(SavedBookDTO book);
    ResponseEntity<String> deleteBookById(String id);
    ResponseEntity<?> getBookById(String id);
    List<ThreeMostSellBookDTO> find3MostSoldBook(String id);
    Long getNumberOfBooks(AuthorDTO authorDTO);
    boolean checkQuantity(String id);
    void removePublisher(String id);
}
