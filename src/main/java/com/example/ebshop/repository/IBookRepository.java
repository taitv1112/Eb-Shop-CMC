package com.example.ebshop.repository;

import com.example.ebshop.dto.response.BookDTO;
import com.example.ebshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,String> {

//    @Query(nativeQuery = false, value = "SELECT b.name " +
//                                        "FROM Book b " +
//                                        "WHERE b.id = :id and b.status = '1' " )
    boolean existsBookByAuthor_IdAndStatusContains( String id,String status);

    <T> T getBookById(Class<T> type, String id);

    String countBooksByAuthor_Id(String id);

    @Query(nativeQuery = true, value = "SELECT b.name as name, a.name as authorName, p.name as publisherName, b.price as price   FROM `eb-shop`.book b " +
                                        "INNER JOIN `eb-shop`.author a " +
                                        " ON b.author_id = a.id " +
                                        "JOIN `eb-shop`.publisher p ON b.publisher_id = p.id " +
                                        "WHERE a.id = :id " +
                                        "ORDER BY b.quantity_sold DESC limit 3" )
    List<BookDTO> getThreeBestSoldBooksByAuthorId(@Param("id") String id);
}
