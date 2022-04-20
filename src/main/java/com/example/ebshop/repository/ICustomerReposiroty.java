package com.example.ebshop.repository;

import com.example.ebshop.dto.request.CustomerDTO;
import com.example.ebshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerReposiroty extends JpaRepository<Customer,String> {
    boolean existsCustomerByEmail(String email);
    Customer findByEmail(String email);
    CustomerDTO findByOrderById(String idOrder);
}
