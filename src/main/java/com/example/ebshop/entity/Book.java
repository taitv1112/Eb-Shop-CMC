package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Book {
    @Id
    @Column(length = 254)
    private String id;
    private String name;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    private BigDecimal price;
    private Date publishedYear;
    private String status;
    private Long quantityCurrent;
    private Long quantitySold;

    public Book(String id) {
        this.id = id;
    }

    public Book() {
    }

    public Book(String id, String name, Author author, Publisher publisher, BigDecimal price, Date publishedYear, String status, Long quantityCurrent, Long quantitySold) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.publishedYear = publishedYear;
        this.status = status;
        this.quantityCurrent = quantityCurrent;
        this.quantitySold = quantitySold;
    }
}
