package com.example.ebshop.service.impl;

import com.example.ebshop.dto.OrderDTO;
import com.example.ebshop.entity.Orders;
import com.example.ebshop.repository.CustomerRepository;
import com.example.ebshop.repository.OrdersRepository;
import com.example.ebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements IOrderService {
    static int id = 0;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders saveOrders(OrderDTO orderDTO) {
        String idCustomer = ""+id;
        id++;

    }

    @Override
    public void deleteOrdersById(String id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Orders findOrdersById(String id) {
        return ordersRepository.findById(id).get();
    }
}
