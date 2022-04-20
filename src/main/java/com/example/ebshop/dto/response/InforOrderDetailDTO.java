package com.example.ebshop.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InforOrderDetailDTO {
    private String bookName;
    private String authorName;
    private String publishName;
    private BigDecimal price;
    private Long quantity;
}
