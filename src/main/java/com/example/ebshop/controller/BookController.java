package com.example.ebshop.controller;

import com.example.ebshop.dto.request.SaveBook;
import com.example.ebshop.entity.Book;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class BookController {
    @Autowired
    IBookService bookSvc;

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody SaveBook book){
        if(bookSvc.isBookExist(book.getId())){
           bookSvc.updateExistingBook(book);
        } else {
            bookSvc.saveNewBook(book);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        return new ResponseEntity<>(bookSvc.findBookById(id),HttpStatus.OK);
    }


}
