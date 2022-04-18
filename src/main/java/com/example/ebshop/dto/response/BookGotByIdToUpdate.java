package com.example.ebshop.dto.response;

import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Book;
import com.example.ebshop.entity.Publisher;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

//DTO để lấy sách ra từ Id cho update
@Data
public class BookGotByIdToUpdate {
    private String id;
    private String name;
    private Author author;
    private Publisher publisher;
    private BigDecimal price;
    private Date publishedYear;
    private Long quantity;

    public void getData(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.price = book.getPrice();
        this.publishedYear = book.getPublishedYear();
        this.quantity = book.getQuantityCurrent();
    }
}
