package com.example.ebshop.specification.service;

import com.example.ebshop.entity.Book;
import com.example.ebshop.specification.model.Search;
import com.example.ebshop.specification.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class BookSpecificationBuilder {

    private final Search bookSearch;

    public BookSpecificationBuilder(Search bookSearch) {
        this.bookSearch = bookSearch;
    }

    public Specification<Book> build(){
        SearchCriteria searchId = new SearchCriteria("id","=",bookSearch.getBookId());
        SearchCriteria searchBookName = new SearchCriteria("name","like",bookSearch.getBookName());
        SearchCriteria searchAuthor = new SearchCriteria("author","=",bookSearch.getAuthorId());
        SearchCriteria searchPublisher = new SearchCriteria("publisher","=",bookSearch.getPublisherId());
        SearchCriteria searchMin = new SearchCriteria("price",">",bookSearch.getMinPrice());
        SearchCriteria searchMax = new SearchCriteria("price","<",bookSearch.getMaxPrice());
        Specification<Book> where = null;
        if(!StringUtils.isEmpty(bookSearch.getBookId())){
            where = new BookSpecification(searchId);
        }
        if(!StringUtils.isEmpty(bookSearch.getBookName())){
            if(where!=null){
                where = where.and(new BookSpecification(searchBookName));
            } else {
                where = new BookSpecification(searchBookName);
            }
        }
        if(!StringUtils.isEmpty(bookSearch.getAuthorId())){
            if(where!=null){
                where = where.and(new BookSpecification(searchAuthor));
            } else {
                where = new BookSpecification(searchAuthor);
            }
        }
        if(!StringUtils.isEmpty(bookSearch.getPublisherId())){
            if(where!=null){
                where = where.and(new BookSpecification(searchPublisher));
            } else {
                where = new BookSpecification(searchPublisher);
            }
        }
        if(bookSearch.getMinPrice() != null){
            if(where!=null){
                where = where.and(new BookSpecification(searchMin));
            } else {
                where = new BookSpecification(searchMin);
            }
        }
        if(bookSearch.getMaxPrice() != null){
            if(where!=null){
                where = where.and(new BookSpecification(searchMax));
            } else {
                where = new BookSpecification(searchMax);
            }
        }
        return where;
    }
}
