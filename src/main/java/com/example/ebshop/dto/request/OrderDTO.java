package com.example.ebshop.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private CustomerDTO customer;
    private List<OrderDetailDTO> orderDetails;
}
