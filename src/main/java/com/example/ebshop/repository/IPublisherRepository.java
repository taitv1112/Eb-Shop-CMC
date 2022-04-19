package com.example.ebshop.repository;

import com.example.ebshop.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublisherRepository extends JpaRepository<Author,String> {
    boolean existsByName(String name);
}
