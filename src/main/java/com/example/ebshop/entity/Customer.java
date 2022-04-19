package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Customer {
    @Id
    @Column(length = 254)
    @Email
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;

    public Customer() {
    }

    public Customer(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}
