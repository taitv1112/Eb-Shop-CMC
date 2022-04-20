package com.example.ebshop.service.impl;

import com.example.ebshop.dto.PublisherDetailDTO;
import com.example.ebshop.entity.Publisher;
import com.example.ebshop.exception.ApiRequestException;
import com.example.ebshop.repository.BookRepository;
import com.example.ebshop.repository.PublisherRepository;
import com.example.ebshop.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PublisherServiceImpl implements IPublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    @Transactional
    public void delete(String id) {
        if (bookRepository.findAllBookByPublisherId(id).size()==0){
            publisherRepository.deleteById(id);
        }else {
            throw new ApiRequestException("Nhà xuất bản này vẫn đang bày bán sách trong hệ thống");
        }
    }

    @Override
    public Publisher findById(String id) {
        return publisherRepository.findById(id).get();
    }

    @Override
    public PublisherDetailDTO findPublisherById(String id) {
        Publisher publisher = publisherRepository.findById(id).get();
        Long countBookByPublisher = bookRepository.countBookByPublisherId(id);
        List<String> listBookByPublisher = bookRepository.listBookNameByPublisher(id);
        return new PublisherDetailDTO(publisher.getId(), publisher.getName(), listBookByPublisher, countBookByPublisher);
    }
}
