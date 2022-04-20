package com.example.ebshop.repository;

import com.example.ebshop.dto.response.InforOrderDetailDTO;
import com.example.ebshop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,String> {
    @Query(nativeQuery = true, value = "SELECT b.name as bookName,a.name as authorName,p.name as publisherName ,d.price,d.quantity FROM `eb-shop`.order_detail d " +
            "join book b on book_id = b.id " +
            "join author a on b.author_id = a.id " +
            "join publisher p on b.publisher_id = p.id " +
            "where order_id = :id")
    List<InforOrderDetailDTO> getOrderDetails(@Param("id") String idOrder);

    @Query(nativeQuery = true, value = "SELECT sum(quantity*price) FROM `eb-shop`.order_detail where order_id = :id")
    BigDecimal totalBillByOrder(@Param("id") String idOrder);
}
