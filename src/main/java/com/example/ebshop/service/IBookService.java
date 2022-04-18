package com.example.ebshop.service;

import com.example.ebshop.dto.request.SaveBook;
import com.example.ebshop.dto.response.BookGotByIdToUpdate;
import com.example.ebshop.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllBook(Pageable page);
    void saveBook(Book book);
    void deleteById(String id);
    Book findBookById(String id);
    boolean isBookExist(String id);
    void updateExistingBook(SaveBook book);
    void saveNewBook(SaveBook newBook);
    BookGotByIdToUpdate getBookByIdToUpdate(String id);
}
