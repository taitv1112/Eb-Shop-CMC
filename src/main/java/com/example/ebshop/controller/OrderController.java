package com.example.ebshop.controller;

import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.Orders;
import com.example.ebshop.service.ICustomerService;
import com.example.ebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IOrderService ordersService;

    @PostMapping
    public Orders save(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        String status = "Trang thai";
        String id = "1";
        Orders orders = new Orders(id,customer,status);
        ordersService.saveOrders(orders);
        return orders;
    }




}
