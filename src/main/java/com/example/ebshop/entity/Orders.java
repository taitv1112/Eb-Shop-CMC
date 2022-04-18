package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @Column(length = 254)
    private String id;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<OrderDetail> orderDetails;

    public Orders() {
    }

    public Orders(String id, Customer customer, List<OrderDetail> orderDetails) {
        this.id = id;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }
}
