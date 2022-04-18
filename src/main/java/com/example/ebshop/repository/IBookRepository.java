package com.example.ebshop.repository;

import com.example.ebshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,String> {


    boolean existsBookByAuthor_Id(String id);
}
