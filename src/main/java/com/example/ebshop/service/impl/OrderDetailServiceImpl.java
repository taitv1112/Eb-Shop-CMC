package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.OrderDetailDTO;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.repository.OrderDetailRepository;
import com.example.ebshop.service.BookService;
import com.example.ebshop.service.OrderDetailService;
import com.example.ebshop.service.generateId.GenerateRandomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private BookService bookService;

    @Override
    public List<OrderDetail> save(List<OrderDetailDTO> orderDetailsDTO) {
        List<OrderDetail> list = new ArrayList<>();
        for (OrderDetailDTO orderDTO : orderDetailsDTO) {
            String generatedString;
            do{
             generatedString = GenerateRandomId.generate();
            }
            while(orderDetailRepository.existsById(generatedString));
            OrderDetail orderDetail = new OrderDetail(generatedString,bookService.findBookById(orderDTO.getBook().getId()),orderDTO.getQuantity());
            list.add(orderDetail);
            orderDetailRepository.save(orderDetail);
        }
        return list;
    }

}
