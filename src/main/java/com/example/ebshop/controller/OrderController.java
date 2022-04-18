package com.example.ebshop.controller;

import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.service.OrderDetailService;
import com.example.ebshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @Autowired
    OrderDetailService OrderDetailService;

    @PostMapping("/save")
    private ResponseEntity<String> saveOrder(@RequestBody OrderDTO orderDTO){
        return ordersService.saveOrder(orderDTO);
    }
}
