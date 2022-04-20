package com.example.ebshop.dto.request;

import lombok.Data;

@Data
public class OrderBookDTO {
    private String getBookId;

    public OrderBookDTO() {
    }

    public OrderBookDTO(String getBookId) {
        this.getBookId = getBookId;
    }
}
