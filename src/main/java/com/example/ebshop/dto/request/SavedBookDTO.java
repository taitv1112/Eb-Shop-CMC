package com.example.ebshop.dto.request;

import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Publisher;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

//DTO sách từ request vào để update hoặc thêm sách
@Data
public class SavedBookDTO {
    private String bookId;
    private String bookName;
    private Author author;
    private Publisher publisher;
    private BigDecimal price;
    private Date publishedYear;
    private Long quantity;
}
