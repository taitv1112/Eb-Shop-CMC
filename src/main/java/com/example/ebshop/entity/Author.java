package com.example.ebshop.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @Column(length = 254)
    private String authorId;
    private String authorName;
    private String website;
    private String organization;
    private Long totalQuantitySold;

    public Author() {
    }

    public Author(String authorId, String authorName, String website, String organization, Long totalQuantitySold) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.website = website;
        this.organization = organization;
        this.totalQuantitySold = totalQuantitySold;
    }
}
