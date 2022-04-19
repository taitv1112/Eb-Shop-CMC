package com.example.ebshop.service.impl;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.request.PublisherCreateForm;
import com.example.ebshop.repository.IBookRepository;
import com.example.ebshop.repository.IPublisherRepository;
import com.example.ebshop.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements IPublisherService {

    @Autowired
    IPublisherRepository publisherRepository;

    @Autowired
    IBookRepository bookRepository;

    @Override
    public void createPublisher(PublisherCreateForm publisherCreateForm) throws ExceptionHandling {
        if(existsByName(publisherCreateForm.getPublisherName())){
            throw new ExceptionHandling("Tác giả đã tồn tại!");
        }
        publisherRepository.save(publisherCreateForm.toEntity());
    }

//    @Override
//    public void updateAuthor(AuthorCreateForm authorUpdateForm) throws EntityNotFoundException {
//        if(getAuthorById(authorUpdateForm.getAuthorId()) == null){
//            throw new EntityNotFoundException();
//        }
//        authorRepository.save(authorUpdateForm.toEntity());
//    }
//
//
//    @Override
//    public void deleteByAuthorId(String id) throws ExceptionHandling {
//        if(getAuthorById(id) == null){
//            throw new EntityNotFoundException();
//        }
//        if(bookRepository.existsBookByAuthor(id)){
//            throw new ExceptionHandling("Tác giả vẩn còn sách trong kho. Không được xóa!");
//        }
//
//        authorRepository.deleteById(id);
//    }
//

//    @Override
//    public void getAuthorByName(String name) {
//        authorRepository.getAuthorByName(name);
//    }

    @Override
    public boolean existsByName(String name){
       return publisherRepository.existsByName(name);
    }

//    @Override
//    public AuthorDto getAuthorById( String id) {
//        return  authorRepository.getAuthorById(AuthorDto.class, id);
//    }

}
