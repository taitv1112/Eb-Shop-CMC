package com.example.ebshop.service;

import com.example.ebshop.dto.request.CustomerDTO;
import com.example.ebshop.entity.Customer;

public interface CustomerService {
    Customer findByID(String email);
    Customer save(CustomerDTO customer);
}
