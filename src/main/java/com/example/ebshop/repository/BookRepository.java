package com.example.ebshop.repository;

import com.example.ebshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value ="update book b set b.deleted = true where b.id=:id")
    void softDeleteBookById(@Param("id") String id);
}
