package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Publisher {
    @Id
    @Column(length = 254)
    private String id ;
    @NotEmpty
    private String name;
}
