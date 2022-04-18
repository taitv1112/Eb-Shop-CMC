package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.OrderDetailDTO;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.repository.OrderDetailRepository;
import com.example.ebshop.service.BookService;
import com.example.ebshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<OrderDetail> save(List<OrderDetailDTO> orderDetailsDTO) {
        List<OrderDetail> list = new ArrayList<>();
        for (OrderDetailDTO orderDTO : orderDetailsDTO) {
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
            while(orderDetailRepository.existsById(generatedString));
            OrderDetail orderDetail = new OrderDetail(generatedString,bookService.findBookById(orderDTO.getBook().getId()),orderDTO.getQuantity(),orderDTO.getPrice());
            list.add(orderDetail);
            orderDetailRepository.save(orderDetail);
        }
        return list;
    }
}
