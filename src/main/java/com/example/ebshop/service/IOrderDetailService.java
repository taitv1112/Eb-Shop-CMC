package com.example.ebshop.service;

import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;

public interface IOrderDetailService {
    OrderDetail create(OrderDetail orderDetail);
    OrderDetail update(OrderDetail orderDetail);
    void delete(String id);
}
