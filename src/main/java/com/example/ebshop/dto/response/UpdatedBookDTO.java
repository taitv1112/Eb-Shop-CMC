package com.example.ebshop.dto.response;

import java.math.BigDecimal;
import java.util.Date;

//DTO để lấy sách ra từ Id cho update
public interface UpdatedBookDTO {
    String getBookId();
    String getBookName();
    authorDTO getAuthor();
    publisherDTO getPublisher();
    BigDecimal getPrice();
    Date getPublishedYear();
    Long getQuantityCurrent();

    interface authorDTO{
        String getAuthorId();
        String getAuthorName();
    }
    interface publisherDTO{
        String getPublisherId();
        String getPublisherName();
    }
}
