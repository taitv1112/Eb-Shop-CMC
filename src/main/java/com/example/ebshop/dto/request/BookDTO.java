package com.example.ebshop.dto.request;

import lombok.Data;

@Data
public class BookDTO {
    private String id;

    public BookDTO() {
    }

    public BookDTO(String id) {
        this.id = id;
    }
}
