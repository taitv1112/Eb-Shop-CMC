package com.example.ebshop.service.impl;

import com.example.ebshop.entity.Publisher;
import com.example.ebshop.repository.PublisherRepository;
import com.example.ebshop.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublisherServiceImpl implements IPublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(String id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Publisher findById(String id) {
        return publisherRepository.findById(id).get();
    }
}
