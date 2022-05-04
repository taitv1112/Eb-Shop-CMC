package com.example.ebshop.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookSearch {
    private String name;
    private String authorName;
    private String publisherName;
    private String status;
    private BigDecimal priceStart;
    private BigDecimal priceEnd;

    public BookSearch() {
    }

    public BookSearch(String name, String authorName, String publisherName, String status, BigDecimal priceStart, BigDecimal priceEnd) {
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.status = status;
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(BigDecimal priceStart) {
        this.priceStart = priceStart;
    }

    public BigDecimal getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(BigDecimal priceEnd) {
        this.priceEnd = priceEnd;
    }
}
