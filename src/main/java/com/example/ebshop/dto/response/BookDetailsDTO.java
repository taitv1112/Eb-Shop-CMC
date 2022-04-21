package com.example.ebshop.dto.response;


public interface BookDetailsDTO {
    String getBookId();
    String getBookName();
    AuthorDTO getAuthor();
    PublisherDTO getPublisher();
    Long getQuantitySold();

  interface AuthorDTO{
      String getAuthorId();
      String getAuthorName();
  }

  interface PublisherDTO{
      String getPublisherId();
      String getPublisherName();
  }
}
