package com.example.ebshop.service;

import com.example.ebshop.dto.AuthorDetailDTO;
import com.example.ebshop.dto.PublisherDetailDTO;
import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Publisher;

import java.util.List;

public interface IPublisherService {
    List<Publisher> findAll();
    Publisher save(Publisher publisher);
    void delete(String id);
    Publisher findById(String id);

    PublisherDetailDTO findPublisherById(String id);
}
