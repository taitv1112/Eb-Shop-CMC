package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.CustomerDTO;
import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.repository.CustomerRepository;
import com.example.ebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findByID(String email) {
        if(ObjectUtils.isEmpty(customerRepository.findById(email))) return null;
        return customerRepository.findById(email).get();
    }

    @Override
    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getEmail(), customerDTO.getName(), customerDTO.getPhone());
        customerRepository.save(customer);
        return customer;
    }
}
