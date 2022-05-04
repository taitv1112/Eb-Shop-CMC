package com.example.ebshop.controller;


import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.dto.response.OrderInforDTO;
import com.example.ebshop.entity.Book;
import com.example.ebshop.service.ICustomerService;
import com.example.ebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    @Autowired
    IOrderService iOrderService;
    @Autowired
    ICustomerService iCustomerService;

    @Qualifier("demo2")
    @Autowired
    Book book;
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) throws ExceptionHandling {
        iOrderService.create(orderDTO);
        return new ResponseEntity<String>("Created success !", HttpStatus.OK);
    }

    @GetMapping("/infor/{id}")
    public ResponseEntity<OrderInforDTO> inforOrder(@PathVariable String id) {
        System.out.println(book.getId());
        System.out.println(book.getId());
        System.out.println(book.getId());
        System.out.println(book.getId());
        System.out.println(book.getId());
        System.out.println(book.getId());
        return new ResponseEntity<>(iOrderService.inforOder(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id) {

        return new ResponseEntity<>(iCustomerService.updateCustomer("abcc",id), HttpStatus.OK);
    }

}
