package com.example.ebshop.specification;

import com.example.ebshop.dto.request.BookSearch;
import com.example.ebshop.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecificationBuilder {
    private BookSearch bookSearch;

    public BookSpecificationBuilder(BookSearch bookSearch) {
        this.bookSearch = bookSearch;
    }
    public Specification<Book> build(){
        SearchCriteria searchNameBook = new SearchCriteria("name","like",bookSearch.getName());
        SearchCriteria searchAuthorName = new SearchCriteria("author","like",bookSearch.getAuthorName());
        SearchCriteria searchPublisherName = new SearchCriteria("name","like",bookSearch.getPublisherName());
        SearchCriteria minPrice = new SearchCriteria("name","like",bookSearch.getPriceStart());
        SearchCriteria maxPrice = new SearchCriteria("name","like",bookSearch.getPriceEnd());

        Specification<Book> where = null;

        // search name book
        if(! (bookSearch.getName() == null)){
            where = new BookSpecification(searchNameBook);
        }
        //
        if(! (bookSearch.getAuthorName() == null)){
            if(where != null){
                where = where.and(new BookSpecification(searchAuthorName));
            }else {
                where = new BookSpecification(searchNameBook);
            }
        }
        if(! (bookSearch.getPublisherName() == null)){
            if(where != null){
                where = where.and(new BookSpecification(searchPublisherName));
            }else {
                where = new BookSpecification(searchPublisherName);
            }
        }
        if(! (bookSearch.getPriceStart() == null)){
            if(where != null){
                where = where.and(new BookSpecification(minPrice));
            }else {
                where = new BookSpecification(minPrice);
            }
        }
        if(! (bookSearch.getPriceEnd() == null)){
            if(where != null){
                where = where.and(new BookSpecification(maxPrice));
            }else {
                where = new BookSpecification(maxPrice);
            }
        }
        return where;
    }
}
