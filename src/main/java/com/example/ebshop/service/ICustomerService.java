package com.example.ebshop.service;

import com.example.ebshop.entity.Customer;

public interface ICustomerService {
    boolean existsCustomerByEmail(String email);
    Customer create(Customer customer);
    Customer update(Customer customer);

}
