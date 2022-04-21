package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.SaveOrderDTO;
import com.example.ebshop.dto.request.OrderDetailDTO;
import com.example.ebshop.dto.response.ShowOrderDTO;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Orders;
import com.example.ebshop.repository.OrdersRepository;
import com.example.ebshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
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

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    //Them order
    @Override
    public ResponseEntity<String> saveOrder(SaveOrderDTO saveOrderDTO) {
        for (OrderDetailDTO orderDetails: saveOrderDTO.getOrderDetails()) {
            if(ObjectUtils.isEmpty(orderDetails)) return ResponseEntity.status(HttpStatus.OK).body("Missing order!");
            if(ObjectUtils.isEmpty(orderDetails.getBook())) return ResponseEntity.status(HttpStatus.OK).body("Missing book!");
        }
        if(ObjectUtils.isEmpty(saveOrderDTO.getCustomer())) return ResponseEntity.status(HttpStatus.OK).body("Missing customer!");
        for (OrderDetailDTO orderDetailDTO: saveOrderDTO.getOrderDetails()) {
            if(!bookService.isEnoughBook(orderDetailDTO.getBook())){
                return ResponseEntity.status(HttpStatus.OK).body(orderDetailDTO.getBook().getGetBookId()+" not enough book!");
            }
            if(!bookService.isDeleted(orderDetailDTO.getBook().getGetBookId())){
                return ResponseEntity.status(HttpStatus.OK).body(orderDetailDTO.getBook().getGetBookId()+" got deleted!");
            }
        }
        Customer customer = customerService.findByID(saveOrderDTO.getCustomer().getEmail());
        if(ObjectUtils.isEmpty(customer)) customer = customerService.save(saveOrderDTO.getCustomer());
        List<OrderDetail> orderDetails = orderDetailService.save(saveOrderDTO.getOrderDetails());
        String generatedString;
        BigDecimal totalPrice = new BigDecimal("0");
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
        for (OrderDetail orderDetail: orderDetails) {
            BigDecimal price = orderDetail.getBook().getPrice();
            price = price.multiply(BigDecimal.valueOf(orderDetail.getQuantity()));
            totalPrice = totalPrice.add(price);
        }
        Orders order = new Orders(generatedString,customer,orderDetails,totalPrice);
        ordersRepository.save(order);
        bookService.soldBook(orderDetails);
        authorService.soldBook(orderDetails);
        publisherService.soldBook(orderDetails);
        customerService.buyBook(orderDetails,customer.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }

    //Lay ra order
    @Override
    public ResponseEntity<?> getOrder(String id) {
        if(!ordersRepository.existsById(id)) return ResponseEntity.status(HttpStatus.OK).body("Wrong id!");
        ShowOrderDTO showOrderDTO = ordersRepository.findAllById(ShowOrderDTO.class,id);
        return ResponseEntity.status(HttpStatus.OK).body(showOrderDTO);
    }
}
