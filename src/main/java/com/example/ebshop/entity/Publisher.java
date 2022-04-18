package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Publisher {
    @Id
    @Column(length = 254)
    private String id ;
    @Column(unique = true, nullable = false)
    private String name;
}
