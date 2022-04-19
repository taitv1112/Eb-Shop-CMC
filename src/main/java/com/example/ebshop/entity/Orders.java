package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Orders {
    @Id
    @Column(length = 254)
    private String id;
    @ManyToOne
    private Customer customer;
    private String status ;

    public Orders(Customer customer, String status) {
        this.customer = customer;
        this.status = status;
    }
}
