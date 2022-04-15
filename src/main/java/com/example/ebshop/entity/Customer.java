package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @Column(length = 254)
    private String id;
    private String email;
    private String phone;
    private String name;
    private String address;
}
