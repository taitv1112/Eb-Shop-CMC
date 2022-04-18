package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.dto.request.OrderDetailDTO;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Orders;
import com.example.ebshop.repository.OrdersRepository;
import com.example.ebshop.service.CustomerService;
import com.example.ebshop.service.OrderDetailService;
import com.example.ebshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderDetailService orderDetailService;

    @Override
    public ResponseEntity<String> saveOrder(OrderDTO orderDTO) {
        for (OrderDetailDTO orderDetails:orderDTO.getOrderDetails()) {
            if(ObjectUtils.isEmpty(orderDetails)) return ResponseEntity.status(HttpStatus.OK).body("Missing order!");
            if(ObjectUtils.isEmpty(orderDetails.getBook())) return ResponseEntity.status(HttpStatus.OK).body("Missing book!");
        }
        if(ObjectUtils.isEmpty(orderDTO.getCustomer())) return ResponseEntity.status(HttpStatus.OK).body("Missing customer!");
        Customer customer = customerService.findByID(orderDTO.getCustomer().getEmail());
        if(ObjectUtils.isEmpty(customer)) customer = customerService.save(orderDTO.getCustomer());
        List<OrderDetail> orderDetails = orderDetailService.save(orderDTO.getOrderDetails());
        String generatedString;
        do {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        while(ordersRepository.existsById(generatedString));
        Orders order = new Orders(generatedString,customer,orderDetails);
        ordersRepository.save(order);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }
}
