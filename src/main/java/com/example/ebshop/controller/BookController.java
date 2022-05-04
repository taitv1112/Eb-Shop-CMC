package com.example.ebshop.controller;

import com.example.ebshop.dto.request.BookSearch;
import com.example.ebshop.entity.Book;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/books")
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping()
    public ResponseEntity<?> getAllTours( ){
        BookSearch bookSearch = new BookSearch("demo","aaaa",null,null,null,null);
        List<Book> books = iBookService.getAllBooks( bookSearch);
        //convert entity to DTOs

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
