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
}
