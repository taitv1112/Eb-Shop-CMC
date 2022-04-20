package com.example.ebshop.controller;

import com.example.ebshop.entity.Book;
import com.example.ebshop.exception.ApiRequestException;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping()
    public List<Book> findAllBook(){
        return bookService.findAllBookByStatus();
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book),HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable String id){
        bookService.deleteBookById(id);
    }

    @PutMapping
    public ResponseEntity<Book> edit(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book),HttpStatus.OK);
    }

}
