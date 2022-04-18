package com.example.ebshop.service;

import com.example.ebshop.entity.Publisher;
import org.springframework.http.ResponseEntity;

public interface PublisherService {
    ResponseEntity<String> save(Publisher publisher);
    ResponseEntity<?> findById(String id);
}
