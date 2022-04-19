package com.example.ebshop.dto.request;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private BookDTO book;
    private Long quantity;
}
