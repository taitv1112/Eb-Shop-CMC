package com.example.ebshop.service;


import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.dto.response.OrderInforDTO;
import com.example.ebshop.entity.Orders;
import org.springframework.validation.BindingResult;

public interface IOrderService {
    String PENDING = "PENDING";
    void create(OrderDTO orders) throws ExceptionHandling;

    OrderInforDTO inforOder(String id);
}
