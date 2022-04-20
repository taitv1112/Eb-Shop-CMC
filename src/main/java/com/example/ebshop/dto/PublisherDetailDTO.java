package com.example.ebshop.dto;

import lombok.Data;

import java.util.List;
@Data
public class PublisherDetailDTO {
    private String id;
    private String namePublisher;
    private List<String> bookList;
    private Long quantity_sold;

    public PublisherDetailDTO(String id, String namePublisher, List<String> bookList, Long quantity_sold) {
        this.id = id;
        this.namePublisher = namePublisher;
        this.bookList = bookList;
        this.quantity_sold = quantity_sold;
    }

    public PublisherDetailDTO() {
    }
}
