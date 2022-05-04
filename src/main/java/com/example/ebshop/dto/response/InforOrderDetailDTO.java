package com.example.ebshop.dto.response;



import java.math.BigDecimal;


public interface InforOrderDetailDTO {
     String getBookName();
     String getAuthorName();
     String getPublishName();
     BigDecimal getPrice();
     Long getQuantity();


}
