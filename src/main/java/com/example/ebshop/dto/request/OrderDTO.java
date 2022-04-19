package com.example.ebshop.dto.request;

import com.example.ebshop.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
   private List<OrderDetailDTO> orderDetailDTOS;
    private CustomerDTO customerDTO;
}
