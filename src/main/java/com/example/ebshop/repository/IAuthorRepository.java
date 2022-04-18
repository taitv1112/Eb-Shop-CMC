package com.example.ebshop.repository;

import com.example.ebshop.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,String> {

    void getAuthorByName(String name);

    boolean existsByName(String name);

    <T> T getAuthorById(Class<T> type, String id);

}
