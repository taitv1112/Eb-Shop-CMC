package com.example.ebshop.service;

import com.example.ebshop.dto.request.OrderDTO;
import org.springframework.http.ResponseEntity;

public interface OrdersService {
    ResponseEntity<String> saveOrder(OrderDTO orderDTO);
}
