package com.example.ebshop.dto.request;

import com.example.ebshop.dto.response.BookDTO;
import com.example.ebshop.entity.Book;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDTO {
    private String bookId;
    private Long quantity;
    private BigDecimal price;
}
