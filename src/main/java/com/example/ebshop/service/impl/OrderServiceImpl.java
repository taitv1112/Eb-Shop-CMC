package com.example.ebshop.service.impl;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.dto.request.OrderDetailDTO;
import com.example.ebshop.entity.Book;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Orders;
import com.example.ebshop.repository.IBookRepository;
import com.example.ebshop.repository.ICustomerReposiroty;
import com.example.ebshop.repository.IOrderDetailRepository;
import com.example.ebshop.repository.IOrderRepository;
import com.example.ebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    IOrderDetailRepository iOrderDetailRepository;
    @Autowired
    ICustomerReposiroty iCustomerReposiroty;
    @Autowired
    IBookRepository iBookRepository;

    @Override
    @Transactional
    public void create(OrderDTO orderDTO) throws ExceptionHandling {
        Customer customer ;
        if(iCustomerReposiroty.existsCustomerByEmail(orderDTO.getCustomerDTO().getEmail())){
            customer = iCustomerReposiroty.findByEmail(orderDTO.getCustomerDTO().getEmail());
        }else {
             customer = iCustomerReposiroty.save(new Customer(orderDTO.getCustomerDTO().getEmail(),orderDTO.getCustomerDTO().getName(),orderDTO.getCustomerDTO().getPhone())) ;
        }
        Orders orders =  iOrderRepository.save(new Orders(customer,IOrderService.PENDING));
        for (OrderDetailDTO o:orderDTO.getOrderDetailDTOS()) {
            Book book = iBookRepository.getById(o.getBookId());
            if(book.getQuantityCurrent() < o.getQuantity() || o.getQuantity() < 0){
                throw new ExceptionHandling("403",book.getName() +" are " + book.getQuantityCurrent() + " available");
            }
            iOrderDetailRepository.save(new OrderDetail(orders,book,o.getQuantity(),o.getPrice()));
            book.setQuantityCurrent(o.getQuantity()-book.getQuantityCurrent());
            book.setQuantitySold(book.getQuantitySold()+o.getQuantity());
            iBookRepository.save(book);
        }
    }
}
