package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.AuthorDTO;
import com.example.ebshop.dto.request.SavedBookDTO;
import com.example.ebshop.dto.response.ThreeMostSellBookDTO;
import com.example.ebshop.dto.response.UpdatedBookDTO;
import com.example.ebshop.entity.Book;
import com.example.ebshop.repository.BookRepository;
import com.example.ebshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    // lưu lại sách
    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    //Tìm sách theo id
    @Override
    public Book findBookById(String id) {
        return bookRepository.findById(id).get();
    }

    //Kiểm tra xem sách đã tồn tại chưa
    private boolean isBookExist(String id) {
        return bookRepository.existsById(id);
    }

    //Cập nhật lại sách đã tồn tại
    private void updateExistingBook(SavedBookDTO book) {
        Book oldBook = findBookById(book.getId());
        if(oldBook.getDeleted()) return;
        transferDataFromSaveBookToBook(book, oldBook);
        saveBook(oldBook);
    }

    // lưu sách mới
    private void saveNewBook(SavedBookDTO newBook) {
        Book book = new Book();
        if(newBook.getId().equals("0")||newBook.getId()==null) book.setId("0");
        else book.setId(newBook.getId());
        transferDataFromSaveBookToBook(newBook,book);
        book.setDeleted(false);
        book.setQuantitySold(0L);
        saveBook(book);
    }

    // Chuyển dữ liệu từ DTO
    private void transferDataFromSaveBookToBook(SavedBookDTO book, Book oldBook) {
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
    private UpdatedBookDTO getBookByIdToUpdate(String id) {
        Book book = findBookById(id);
        if(book.getDeleted()) return null;
        UpdatedBookDTO bookDTO = bookRepository.findAllById(UpdatedBookDTO.class,id);
        return bookDTO;
    }

    // Đổi delete từ false sang true
    private void softDeleteBookById(String id) {
        bookRepository.softDeleteBookById(id);
    }

    // Check xem đã xóa chưa
    private boolean isDeleted(String id) {
        Book book = bookRepository.isDeleted(id);
        return book != null;
    }

    // Lưu sách hoặc update sách
    @Override
    public ResponseEntity<String> saveBookToStorage(SavedBookDTO book) {
        if(isDeleted(book.getId())) return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        if(isBookExist(book.getId())){
            updateExistingBook(book);
            return ResponseEntity.status(HttpStatus.OK).body("Updated success!");
        } else {
            saveNewBook(book);
            return ResponseEntity.status(HttpStatus.OK).body("Added success!");
        }
    }

    //Soft delete sách
    @Override
    public ResponseEntity<String> deleteBookById(String id) {
        //Kiểm tra xem sách có tồn tại hay đã bị soft delete không?
        if(!isBookExist(id)) return ResponseEntity.status(HttpStatus.OK).body("Not found!");
        if(isDeleted(id)) return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        softDeleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
    }

    // Tìm sách theo Id
    @Override
    public ResponseEntity<?> getBookById(String id) {
        UpdatedBookDTO book = getBookByIdToUpdate(id);
        if(book==null) return ResponseEntity.status(HttpStatus.OK).body("Not found!");
        else return new ResponseEntity<>(book,HttpStatus.OK);
    }

    // Lấy ra 3 cuốn sách bán chạy nhất
    @Override
    public List<ThreeMostSellBookDTO> find3MostSoldBook(String id) {
        return bookRepository.find3MostSoldBook(ThreeMostSellBookDTO.class,id);
    }

    //Lấy ra số lượng sách
    @Override
    public Long getNumberOfBooks(AuthorDTO authorDTO) {
        return bookRepository.countByAuthor(authorDTO.getId());
    }
}
