package com.example.ebshop.service;

import com.example.ebshop.dto.request.BookSearch;
import com.example.ebshop.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks( BookSearch bookSearch);

}
