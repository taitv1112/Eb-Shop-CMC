package com.example.ebshop.repository;

import com.example.ebshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    @Modifying
    @Transactional
    @Query("update Book b set b.deleted = true where b.id=?1")
    void softDeleteBookById(String id);

    @Query("select b from Book b where b.id=?1 and b.deleted=true")
    Book isDeleted(String id);
}
