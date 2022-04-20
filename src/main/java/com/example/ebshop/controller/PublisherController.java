package com.example.ebshop.controller;

import com.example.ebshop.dto.PublisherDetailDTO;
import com.example.ebshop.entity.Publisher;

import com.example.ebshop.service.IAuthorService;
import com.example.ebshop.service.IPublisherService;
import com.example.ebshop.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PublisherController {
    @Autowired
    IPublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> findAllPublisher(){
        return new ResponseEntity<>(publisherService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher){
        return new ResponseEntity<>(publisherService.save(publisher),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Publisher> editPublisher(@RequestBody Publisher publisher){
        return new ResponseEntity<>(publisherService.save(publisher),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        publisherService.delete(id);
    }

    @GetMapping("/{id}")
    public PublisherDetailDTO findPublisherById(@PathVariable String id){
        return publisherService.findPublisherById(id);
    }



}
