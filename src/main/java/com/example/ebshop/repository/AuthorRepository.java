package com.example.ebshop.repository;

import com.example.ebshop.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    <T> T findAuthorById(Class<T> classType, String id);

    @Query("select distinct b from Book b order by b.quantitySold desc")
    <T> Page<T> fiveBestSeller(Class<T> classType, Pageable page);

    <T> List<T> findAllBy(Class<T> classType);

    @Modifying
    @Transactional
    @Query("update Author set totalQuantitySold = totalQuantitySold + ?1 where id =?2")
    void soldBook(Long quantity, String id);
}
