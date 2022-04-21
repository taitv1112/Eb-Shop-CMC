package com.example.ebshop.service.impl;

import com.example.ebshop.dto.SortForCustomerBook;
import com.example.ebshop.dto.SortForCustomerMoney;
import com.example.ebshop.dto.request.CustomerDTO;
import com.example.ebshop.dto.response.BestCustomerDTO;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.repository.CustomerRepository;
import com.example.ebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    //Tìm khách
    @Override
    public Customer findByID(String email) {
        if (ObjectUtils.isEmpty(customerRepository.findById(email))) return null;
        return customerRepository.findById(email).get();
    }

    // Lưu khách
    @Override
    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getEmail(), customerDTO.getName(), customerDTO.getPhone(), 0L, BigDecimal.valueOf(0L));
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void buyBook(List<OrderDetail> orderDetails, String email) {
        for (OrderDetail orderDetail : orderDetails) {
            customerRepository.buyBook(orderDetail.getQuantity(), orderDetail.getBook().getPrice(), email);
        }
    }

    @Override
    public ResponseEntity<?> fiveBestCustomer() {
        List<BestCustomerDTO> list = customerRepository.findAllBy(BestCustomerDTO.class);
        list.sort(new SortForCustomerMoney());
        if(list.size()>5) return ResponseEntity.status(HttpStatus.OK).body(list.subList(0,4));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Override
    public ResponseEntity<?> fiveMostBuyCustomer() {
        List<BestCustomerDTO> list = customerRepository.findAllBy(BestCustomerDTO.class);
        list.sort(new SortForCustomerBook());
        if(list.size()>5) return ResponseEntity.status(HttpStatus.OK).body(list.subList(0,4));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
