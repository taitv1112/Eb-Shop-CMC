package com.example.ebshop.service;

import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Orders;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAllOrderDetail();
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetailById(String id);
    OrderDetail findOrderDetailsById(String id);
}
