package com.example.ebshop.dto.request;

import com.example.ebshop.entity.Author;
import lombok.Data;

@Data
public class AuthorCreateForm {
    private String authorId ;
    private String authorName;

    public Author toEntity(){
        return new Author(authorId, authorName);
    }

}
