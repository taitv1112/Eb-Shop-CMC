package com.example.ebshop.repository;

import com.example.ebshop.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,String> {
    <T>T findPublisherById(Class<T> classType, String id);
}
