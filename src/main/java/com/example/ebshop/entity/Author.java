package com.example.ebshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @Column(length = 254)
    private String id ;
    private String name;
}
