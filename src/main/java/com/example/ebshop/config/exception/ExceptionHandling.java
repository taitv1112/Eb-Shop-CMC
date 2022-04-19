package com.example.ebshop.config.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class ExceptionHandling extends  Exception{

    private HttpStatus status;

    private String message;

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
