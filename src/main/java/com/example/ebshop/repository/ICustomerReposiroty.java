package com.example.ebshop.repository;

import com.example.ebshop.dto.response.ICustomerDTO;
import com.example.ebshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerReposiroty extends JpaRepository<Customer,String> {
    boolean existsCustomerByEmail(String email);
    Customer findByEmail(String email);
    @Query(nativeQuery = true,value = "SELECT c.name , c.email  , c.phone FROM `eb-shop`.customer c " +
            "join orders on c.id = orders.customer_id where orders.id = :id")
    ICustomerDTO findByOrderById(@Param("id") String idOrder);
}
