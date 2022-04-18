package com.example.ebshop.controller;

import com.example.ebshop.dto.request.SavedBookDTO;
import com.example.ebshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    //Update va thêm sách vào kho
    @PostMapping("/save")
    public ResponseEntity<String> saveBook(@RequestBody SavedBookDTO book){
        return bookService.saveBookToStorage(book);
    }

    //Tìm sách theo Id sách
    @GetMapping("//{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id){
       return bookService.getBookById(id);
    }

    //Soft delete sách theo Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        return bookService.deleteBookById(id);
    }
}
