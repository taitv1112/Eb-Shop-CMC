package com.example.ebshop.repository;

import com.example.ebshop.dto.AuthorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface AuthorDetailRepository extends JpaRepository<AuthorDetail,String> {
    @Query(nativeQuery = true, value = "SELECT author.*, book.name, book.quantity_sold FROM author join book" +
            "on author.id = book.author_id " +
            "where book.author_id =:id " +
            "order by book.quantity_sold desc limit 3")
    List<AuthorDetail> findAuthorDetail(@Param("id")String id);
}
