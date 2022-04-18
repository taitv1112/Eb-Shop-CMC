package com.example.ebshop.dto.response;

import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Publisher;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookGotById {
    private String id;
    private String name;
    private Author author;
    private Publisher publisher;
    private BigDecimal price;
    private Date publishedYear;
    private Long quantity;
}
