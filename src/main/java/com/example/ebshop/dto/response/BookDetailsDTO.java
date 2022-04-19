package com.example.ebshop.dto.response;

import com.example.ebshop.dto.request.AuthorDTO;

import java.math.BigDecimal;

public class BookDetailsDTO {
    private String id;
    private AuthorDTO author;
    private PublisherDTO publisher;
    private BigDecimal price;

    public BookDetailsDTO() {
    }

    public BookDetailsDTO(String id, AuthorDTO author, PublisherDTO publisher, BigDecimal price) {
        this.id = id;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
}
