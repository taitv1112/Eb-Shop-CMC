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
    private Orders order;
    @ManyToOne
    private  Book book;
    private Long quantity;
    private BigDecimal price;

    public OrderDetail() {
    }

    public OrderDetail(String id,Orders order, Book book, Long quantity, BigDecimal price) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
        this.id=id;
    }
}
