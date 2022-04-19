package com.example.ebshop.controller;

import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/author")

public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorCreateForm authorCreateForm){
        authorService.createAuthor(authorCreateForm);
        return new ResponseEntity<String>("Created success !", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    //@RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> updateAuthor( @RequestBody  AuthorCreateForm authorCreateForm) throws EntityNotFoundException {
        authorService.updateAuthor(authorCreateForm);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }



}
