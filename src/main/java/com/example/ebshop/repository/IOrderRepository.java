package com.example.ebshop.repository;

import com.example.ebshop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders,String> {

}
