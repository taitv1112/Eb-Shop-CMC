package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;

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

    public Customer(String email, String phone, String name) {
        this.email = email;
        this.phone = phone;
        this.name = name;
    }
}
