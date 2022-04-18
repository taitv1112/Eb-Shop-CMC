package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {
    @Id
    @Column(length = 254)
    private String id;
    @ManyToOne
    private  Book book;
    private Long quantity;
    private BigDecimal price;

    public OrderDetail() {
    }

    public OrderDetail(String id, Book book, Long quantity, BigDecimal price) {
        this.id = id;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }
}
