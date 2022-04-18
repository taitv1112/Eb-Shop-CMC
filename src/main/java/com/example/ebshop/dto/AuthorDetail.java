package com.example.ebshop.dto;

import com.example.ebshop.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDetail {
    private String id;
    private String nameAuthor;
    private List<Book> bookList;
    private Long quantity_sold;

    public AuthorDetail(String id, String nameAuthor, List<Book> bookList, Long quantity_sold) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.bookList = bookList;
        this.quantity_sold = quantity_sold;
    }

    public AuthorDetail() {
    }
}
