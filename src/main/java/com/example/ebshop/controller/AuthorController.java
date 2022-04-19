package com.example.ebshop.controller;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.response.AuthorDetailDto;
import com.example.ebshop.dto.response.BookDTO;
import com.example.ebshop.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.naming.Binding;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.function.Function;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/author")

public class AuthorController {

    @Autowired
    IAuthorService authorService;


    @GetMapping("/getAuthorDetail/{id}")
    public ResponseEntity<?> getAuthorDetailByAuthorId(@PathVariable("id") String id){
        AuthorDetailDto authorDetailDto = authorService.getAuthorDetailByAuthorId(id);
        return new ResponseEntity<>(authorDetailDto, HttpStatus.OK);
    }


    @PostMapping("/create")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorCreateForm authorCreateForm, BindingResult bindingResult) throws ExceptionHandling {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(),HttpStatus.BAD_GATEWAY);
        }
        authorService.createAuthor(authorCreateForm);
        return new ResponseEntity<String>("Created success !", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    //@RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> updateAuthor( @RequestBody  AuthorCreateForm authorCreateForm) throws EntityNotFoundException {
        authorService.updateAuthor(authorCreateForm);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(name = "id") String id) throws ExceptionHandling {
        authorService.deleteByAuthorId(id);
        return new ResponseEntity<String>("Deleted success !", HttpStatus.OK);
    }




}
