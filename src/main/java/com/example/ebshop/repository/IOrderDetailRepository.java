package com.example.ebshop.repository;

import com.example.ebshop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
