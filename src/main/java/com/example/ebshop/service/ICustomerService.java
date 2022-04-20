package com.example.ebshop.service;

import com.example.ebshop.entity.Book;
import com.example.ebshop.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomer();
    Customer saveCustomer(Customer customer);
    void deleteCustomerById(String id);
    Customer findCustomerById(String id);
}
