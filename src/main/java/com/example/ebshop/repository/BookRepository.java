package com.example.ebshop.repository;

import com.example.ebshop.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE `eb-shop`.`book` SET `status` = '0' WHERE (`id` =:id);")
    void deleteBookById(@Param("id") String id);

    @Query(nativeQuery = true, value = "SELECT * FROM `eb-shop`.book where status = '1';")
    List<Book> findAllBookByStatus();

    @Query(nativeQuery = true, value = "SELECT * FROM `eb-shop`.book where book.author_id =:id")
    List<Book> findAllBookByAuthorId(@Param("id") String id);

    @Query(nativeQuery = true, value = "SELECT * FROM `eb-shop`.book where book.publisher_id =:id")
    List<Book> findAllBookByPublisherId(@Param("id") String id);

    @Query(nativeQuery = true, value = "SELECT count(author_id) FROM `eb-shop`.book where author_id =:id")
    Long countBookByAuthorId(@Param("id")String id);

    @Query(nativeQuery = true, value = "SELECT count(publisher_id) FROM `eb-shop`.book where publisher_id =:id")
    Long countBookByPublisherId(@Param("id")String id);

    @Query(nativeQuery = true, value = "SELECT book.name FROM `eb-shop`.book where author_id =:id order by quantity_sold desc limit 3")
    List<String> listBookNameByAuthor(@Param("id")String id);

    @Query(nativeQuery = true, value = "SELECT book.name FROM `eb-shop`.book where publisher_id =:id order by quantity_sold desc limit 5")
    List<String> listBookNameByPublisher(@Param("id")String id);








}
