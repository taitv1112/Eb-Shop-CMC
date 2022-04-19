package com.example.ebshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

public interface BookDTO {
    String getName();
    String getAuthorName();
    String getPublisherName();
    BigDecimal getPrice();;
}
