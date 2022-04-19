package com.example.ebshop.repository;

import com.example.ebshop.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<Publisher,String> {
    boolean existsPublisherByName(String name);
}
