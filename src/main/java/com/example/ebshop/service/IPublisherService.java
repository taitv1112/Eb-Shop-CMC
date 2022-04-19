package com.example.ebshop.service;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.request.PublisherCreateForm;
import com.example.ebshop.dto.response.AuthorDto;

import javax.persistence.EntityNotFoundException;

public interface IPublisherService {
    void createPublisher(PublisherCreateForm publisherCreateForm) throws ExceptionHandling;
    boolean existsByName(String name);

}
