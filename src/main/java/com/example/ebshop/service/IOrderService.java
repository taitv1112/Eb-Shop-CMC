package com.example.ebshop.service;

import com.example.ebshop.entity.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAllOrders();
    Orders saveOrders(Orders orders);
    void deleteOrdersById(String id);
    Orders findOrdersById(String id);
}
