package com.example.ebshop.service.impl;

import com.example.ebshop.entity.Customer;
import com.example.ebshop.repository.CustomerRepository;
import com.example.ebshop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).get();
    }
}
