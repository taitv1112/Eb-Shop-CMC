package com.example.ebshop.service;

import com.example.ebshop.dto.request.CustomerDTO;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    Customer findByID(String email);
    Customer save(CustomerDTO customer);
    void buyBook(List<OrderDetail> orderDetails,String email);
    ResponseEntity<?> fiveBestCustomer();
    ResponseEntity<?> fiveMostBuyCustomer();
}
