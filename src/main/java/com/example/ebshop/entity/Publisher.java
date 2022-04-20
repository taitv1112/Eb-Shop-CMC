package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Publisher {
    @Id
    @Column(length = 254)
    private String publisherId;
    @NotEmpty
    private String publisherName;
    private String website;
    private String address;
    private Long totalQuantitySold;

    public Publisher() {
    }

    public Publisher(String publisherId, String publisherName, String website, String address, Long totalQuantitySold) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.website = website;
        this.address = address;
        this.totalQuantitySold = totalQuantitySold;
    }
}
