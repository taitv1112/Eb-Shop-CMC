package com.example.ebshop.controller;

import com.example.ebshop.dto.request.AuthorDTO;
import com.example.ebshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    //Lưu tác giả vào
    @PostMapping("/save")
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorDTO author) {
       return authorService.saveAuthor(author);
    }

    //Tìm kiếm tác giả
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable String id){
        return authorService.getAuthorById(id);
    }
}
