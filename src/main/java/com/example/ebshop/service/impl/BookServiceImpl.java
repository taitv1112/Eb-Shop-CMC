package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.SaveBook;
import com.example.ebshop.entity.Book;
import com.example.ebshop.repository.BookRepository;
import com.example.ebshop.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookRepository bookRepo;

    @Override
    public Page<Book> findAllBook(Pageable page) {
        return bookRepo.findAll(page);
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book findBookById(String id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public boolean isBookExist(String id) {
        return bookRepo.existsById(id);
    }

    @Override
    public void updateExistingBook(SaveBook book) {
        Book oldBook = findBookById(book.getId());
        transferDataFromSaveBookToBook(book, oldBook);
        saveBook(oldBook);
    }

    private void transferDataFromSaveBookToBook(SaveBook book,Book oldBook) {
         if(book.getName()!=null){
            oldBook.setName(book.getName());
        }
        if(book.getAuthor()!=null){
            oldBook.setAuthor(book.getAuthor());
        }
        if(book.getPrice()!=null){
            oldBook.setPrice(book.getPrice());
        }
        if(book.getPublishedYear()!=null){
            oldBook.setPublishedYear(book.getPublishedYear());
        }
        if(book.getPublisher()!=null){
            oldBook.setPublisher(book.getPublisher());
        }
        if(book.getQuantity()!=null){
            if(oldBook.getQuantityCurrent()==null){
                oldBook.setQuantityCurrent(0L);
            }
            oldBook.setQuantityCurrent(oldBook.getQuantityCurrent()+ book.getQuantity());
        }
    }

    public void saveNewBook(SaveBook newBook) {
        Book book = new Book();
        book.setId(newBook.getId());
        transferDataFromSaveBookToBook(newBook,book);
        saveBook(book);
    }
}
