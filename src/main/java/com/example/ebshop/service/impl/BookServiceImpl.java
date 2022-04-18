package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.SaveBook;
import com.example.ebshop.dto.response.BookGotByIdToUpdate;
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

    // Tìm tất cả sách
    @Override
    public Page<Book> findAllBook(Pageable page) {
        return bookRepo.findAll(page);
    }

    // lưu lại sách
    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    //xóa sách theo id
    @Override
    public void deleteById(String id) {
        bookRepo.deleteById(id);
    }

    //Tìm sách theo id
    @Override
    public Book findBookById(String id) {
        return bookRepo.findById(id).get();
    }

    //Kiểm tra xem sách đã tồn tại chưa
    @Override
    public boolean isBookExist(String id) {

        return bookRepo.existsById(id);
    }

    //Cập nhật lại sách đã tồn tại
    @Override
    public void updateExistingBook(SaveBook book) {
        Book oldBook = findBookById(book.getId());
        if(oldBook.getDeleted()) return;
        transferDataFromSaveBookToBook(book, oldBook);
        saveBook(oldBook);
    }

    // lưu sách mới
    public void saveNewBook(SaveBook newBook) {
        Book book = new Book();
        if(newBook.getId().equals("0")||newBook.getId()==null) book.setId("0");
        else book.setId(newBook.getId());
        transferDataFromSaveBookToBook(newBook,book);
        book.setDeleted(false);
        book.setQuantitySold(0L);
        saveBook(book);
    }

    // Chuyển dữ liệu từ DTO
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

    //Lấy ra Dto của sách từ ID
    @Override
    public BookGotByIdToUpdate getBookByIdToUpdate(String id) {
        Book book = findBookById(id);
        if(book.getDeleted()) return null;
        BookGotByIdToUpdate bookDTO = new BookGotByIdToUpdate();
        bookDTO.getData(book);
        return bookDTO;
    }

    // Đổi delete từ false sang true
    @Override
    public void softDeleteBookById(String id) {
        bookRepo.softDeleteBookById(id);
    }
}
