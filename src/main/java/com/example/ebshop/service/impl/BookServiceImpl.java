package com.example.ebshop.service.impl;

import com.example.ebshop.entity.Book;
import com.example.ebshop.exception.ApiRequestException;
import com.example.ebshop.repository.BookRepository;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBookByStatus() {
        if (bookRepository.findAllBookByStatus().size()!=0){
            return bookRepository.findAllBookByStatus();
        }else {
            throw new ApiRequestException("Không có mục nào");
        }
    }

    @Override
    public Book save(Book book){
            return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBookById(String id) {
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteBookById(id);
        }else {
            throw new ApiRequestException("Không tồn tại ID này");
        }

    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findAllBookByPublisherId(String id) {
        return bookRepository.findAllBookByPublisherId(id);
    }
}
