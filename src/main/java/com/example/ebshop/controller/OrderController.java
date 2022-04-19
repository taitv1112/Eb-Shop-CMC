package com.example.ebshop.controller;

import com.example.ebshop.dto.request.SaveOrderDTO;
import com.example.ebshop.service.CustomerService;
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

    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    private ResponseEntity<String> saveOrder(@RequestBody SaveOrderDTO saveOrderDTO){
        return ordersService.saveOrder(saveOrderDTO);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getOrder(@PathVariable String id){
        return ordersService.getOrder(id);
    }

    @GetMapping("/best-seller")
    private ResponseEntity<?> fiveBestCustomer(){
        return customerService.fiveBestCustomer();
    }
}
