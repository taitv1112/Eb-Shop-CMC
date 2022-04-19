package com.example.ebshop.service.impl;

import com.example.ebshop.entity.Customer;
import com.example.ebshop.repository.ICustomerReposiroty;
import com.example.ebshop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;

public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerReposiroty iCustomerReposiroty;

    @Override
    public boolean existsCustomerByEmail(String email) {
        return iCustomerReposiroty.existsCustomerByEmail(email);
    }

    @Override
    public Customer create(Customer customer) {
        return iCustomerReposiroty.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return iCustomerReposiroty.save(customer);
    }
}
