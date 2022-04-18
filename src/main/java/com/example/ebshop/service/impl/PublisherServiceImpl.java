package com.example.ebshop.service.impl;

import com.example.ebshop.dto.response.PublisherDTO;
import com.example.ebshop.entity.Publisher;
import com.example.ebshop.repository.PublisherRepository;
import com.example.ebshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public ResponseEntity<String> save(Publisher publisher) {
        publisherRepository.save(publisher);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        PublisherDTO publisher = publisherRepository.findPublisherById(PublisherDTO.class,id);
        if(ObjectUtils.isEmpty(publisher)) return ResponseEntity.status(HttpStatus.OK).body("Not found!");
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(Publisher publisher) {
        PublisherDTO publisherDTO = publisherRepository.findPublisherById(PublisherDTO.class, publisher.getId());
        if(ObjectUtils.isEmpty(publisherDTO)) return ResponseEntity.status(HttpStatus.OK).body("Not found!");
        if(publisher.getName()==null){
            publisher.setName(publisherDTO.getName());
        }
        publisherRepository.save(publisher);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }
}
