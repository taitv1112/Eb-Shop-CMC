package com.example.ebshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @Column(length = 254)
    private String id ;
    private String name;

}
