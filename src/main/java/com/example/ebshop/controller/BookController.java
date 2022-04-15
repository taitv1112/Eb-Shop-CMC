package com.example.ebshop.controller;

import com.example.ebshop.entity.Book;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/book")
    public ResponseEntity<List<Book>> findAllCategory(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book),HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(@PathVariable String id){

    }
}
