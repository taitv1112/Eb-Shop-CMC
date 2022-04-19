package com.example.ebshop.dto.request;

import com.example.ebshop.entity.Author;
import lombok.Data;

@Data
public class PublisherCreateForm {
    private String publisherId ;
    private String publisherName;

    public Author toEntity(){
        return new Author(publisherId, publisherName);
    }

}
