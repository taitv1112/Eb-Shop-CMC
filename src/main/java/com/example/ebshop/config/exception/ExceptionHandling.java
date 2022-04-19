package com.example.ebshop.config.exception;

import org.springframework.http.HttpStatus;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ExceptionHandling extends  Exception{

    private HttpStatus status;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp = new Date();
}
