package com.example.ebshop.service;

import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Publisher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublisherService {
    ResponseEntity<String> save(Publisher publisher);
    ResponseEntity<?> findById(String id);
    ResponseEntity<String> update(Publisher publisher);
    ResponseEntity<String> deletePublisher(String id);
    ResponseEntity<?> getBestseller();
    void soldBook(List<OrderDetail> orderDetails);
}
