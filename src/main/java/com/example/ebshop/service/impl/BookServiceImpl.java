package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.BookSearch;
import com.example.ebshop.entity.Book;
import com.example.ebshop.repository.IBookRepository;
import com.example.ebshop.service.IBookService;
import com.example.ebshop.specification.BookSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;


    public List<Book> getAllBooks( BookSearch bookSearch) {
        BookSpecificationBuilder specificationBuilder = new BookSpecificationBuilder(bookSearch);
        return bookRepository.findAll(specificationBuilder.build());
    }
}
