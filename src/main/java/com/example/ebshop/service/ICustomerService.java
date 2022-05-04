package com.example.ebshop.service;

import com.example.ebshop.entity.Customer;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    boolean existsCustomerByEmail(String email);
    Customer create(Customer customer);
    Customer update(Customer customer);

    Customer updateCustomer(String address , String id);

}
