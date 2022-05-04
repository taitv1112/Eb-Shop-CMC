package com.example.ebshop.config.exception;

import com.example.ebshop.entity.Book;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class ExceptionHandling extends Exception{

    private HttpStatus status;

    private String message;
    @Autowired
    @Qualifier("demo2")
    Book book;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();

    public ExceptionHandling(String status) {
        this.status = HttpStatus.valueOf(status);
    }
    public ExceptionHandling(String status,String message) {
        this.status = HttpStatus.valueOf(status);
        this.message = message;
    }

}
