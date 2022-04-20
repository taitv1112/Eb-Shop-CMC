package com.example.ebshop.repository;

import com.example.ebshop.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,String>, JpaSpecificationExecutor<Publisher> {
    <T>T findPublisherBypublisherId(Class<T> classType, String id);
    <T>List<T> findAllBy(Class<T> classType);
    @Modifying
    @Transactional
    @Query("update Publisher set totalQuantitySold = totalQuantitySold+?1 where publisherId=?2")
    void soldBook(Long quantity, String id);
}
