package com.example.ebshop.service.impl;

import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.repository.OrderDetailRepository;
import com.example.ebshop.repository.OrdersRepository;
import com.example.ebshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> findAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetailById(String id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public OrderDetail findOrderDetailsById(String id) {
        return orderDetailRepository.findById(id).get();
    }
}
