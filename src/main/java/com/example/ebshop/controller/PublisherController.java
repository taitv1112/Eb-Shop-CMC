package com.example.ebshop.controller;

import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Publisher;
import com.example.ebshop.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    IPublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> findAllPublisher(){
        return new ResponseEntity<>(publisherService.findAll(), HttpStatus.OK);
    }

}
