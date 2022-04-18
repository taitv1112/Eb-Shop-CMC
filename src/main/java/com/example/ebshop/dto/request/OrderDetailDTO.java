package com.example.ebshop.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {
    private BookDTO book;
    private Long quantity;
    private BigDecimal price;
}
