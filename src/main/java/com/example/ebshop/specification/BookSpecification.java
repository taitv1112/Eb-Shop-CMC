package com.example.ebshop.specification;

import com.example.ebshop.entity.Author;
import com.example.ebshop.entity.Book;
import com.example.ebshop.entity.Publisher;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.Date;

public class BookSpecification implements Specification<Book> {
    private SearchCriteria searchCriteria;

    public BookSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(searchCriteria.getOperator().equalsIgnoreCase("like")){
            return criteriaBuilder.like(root.get(searchCriteria.getKey()),"%" + searchCriteria.getValue().toString() + "%");
        }

        if(searchCriteria.getOperator().equalsIgnoreCase("like")&& searchCriteria.getKey().equalsIgnoreCase("author")){
            Join<Book, Author> join = root.join("author",JoinType.INNER);
            return criteriaBuilder.like(join.get("name"),"%" + searchCriteria.getValue().toString() + "%");
        }


        if(searchCriteria.getOperator().equalsIgnoreCase("like")&& searchCriteria.getKey().equalsIgnoreCase("publisher")){
            Join<Book, Publisher> join = root.join("publisher",JoinType.INNER);
            return criteriaBuilder.like(join.get("name"),"%" + searchCriteria.getValue().toString() + "%");
        }
        if (searchCriteria.getOperator().equalsIgnoreCase("price >=")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), (BigDecimal) searchCriteria.getValue());
        }

        if (searchCriteria.getOperator().equalsIgnoreCase("price <=")) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), (BigDecimal) searchCriteria.getValue());
        }
        return null;
    }
}
