package com.example.ebshop.dto.response;


public interface BookDetailsDTO {
    String getId();
    String getName();
    AuthorDTO getAuthor();
    PublisherDTO getPublisher();
    Long getQuantitySold();

  interface AuthorDTO{
      String getId();
      String getName();
  }

  interface PublisherDTO{
      String getId();
      String getName();
  }
}
