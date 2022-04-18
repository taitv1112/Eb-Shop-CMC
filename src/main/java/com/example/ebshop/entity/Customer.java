package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @Column(length = 254)
    private String email;
    private String name;
    private String phone;

    public Customer() {
    }

    public Customer(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}
