package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @Column(name = "id",length = 254)
    private String id ;
    private String name;

    public Author() {
    }

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
