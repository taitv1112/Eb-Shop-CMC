package com.example.ebshop.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDetailDto {
    private String name;
    private String numBooks;
    private List<BookDTO> bookDTOs;

    public AuthorDetailDto(String name, String numBooks, List<BookDTO> bookDTOs) {
        this.name = name;
        this.numBooks = numBooks;
        this.bookDTOs = bookDTOs;
    }
}
