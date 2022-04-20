package com.example.ebshop.controller;


import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.AuthorCreateForm;
import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    @Autowired
    IOrderService iOrderService;
    @PostMapping("/create")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) throws ExceptionHandling {
        iOrderService.create(orderDTO);
        return new ResponseEntity<String>("Created success !", HttpStatus.OK);
    }

}
