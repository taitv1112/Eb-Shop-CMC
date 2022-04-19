package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Book {
    @Id
    @Column(length = 254)
    private String id;
    @NotEmpty
    private String name;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    private BigDecimal price;
    @NotEmpty
    private Date publishedYear;
    @NotEmpty
    private Boolean deleted;
    private Long quantityCurrent;
    private Long quantitySold;
}
