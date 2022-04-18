package com.example.ebshop.controller;

import com.example.ebshop.dto.request.SaveBook;
import com.example.ebshop.dto.response.BookGotByIdToUpdate;
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

    //Update va thêm sách vào kho
    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody SaveBook book){
        if(bookSvc.isBookExist(book.getId())){
           bookSvc.updateExistingBook(book);
        } else {
            bookSvc.saveNewBook(book);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Tìm sách theo Id sách
    @GetMapping("/book/{id}")
    public ResponseEntity<BookGotByIdToUpdate> getBookById(@PathVariable String id){
        return new ResponseEntity<>(bookSvc.getBookByIdToUpdate(id),HttpStatus.OK);
    }

}
