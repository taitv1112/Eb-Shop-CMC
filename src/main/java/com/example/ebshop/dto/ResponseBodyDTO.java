package com.example.ebshop.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBodyDTO {
    private String message;
    private HttpStatus code;
    private Object item;

    public ResponseBodyDTO() {

    }

    public ResponseBodyDTO(String message, HttpStatus code, Object item) {
        this.message = message;
        this.code = code;
        this.item = item;
    }

    public ResponseBodyDTO(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
        this.item = item;
    }
}
