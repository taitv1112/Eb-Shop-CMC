package com.example.ebshop.service.impl;

import com.example.ebshop.dto.request.AuthorDTO;
import com.example.ebshop.dto.response.AuthorAdnBookDTO;
import com.example.ebshop.dto.response.ThreeMostSellBookDTO;
import com.example.ebshop.entity.Author;
import com.example.ebshop.repository.AuthorRepository;
import com.example.ebshop.service.AuthorService;
import com.example.ebshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookService bookService;

    //Lưu hoặc cập nhật tác giả
    @Override
    public ResponseEntity<String> saveAuthor(AuthorDTO authorDTO) {
        if (ObjectUtils.isEmpty(authorDTO)) {
            return ResponseEntity.status(HttpStatus.OK).body("Author is null!");
        }
        Author author = new Author(authorDTO.getId(),authorDTO.getName());
        authorRepository.save(author);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }

    //Tìm tác giả từ ID
    @Override
    public ResponseEntity<?> getAuthorById(String id) {
        if(ObjectUtils.isEmpty(authorRepository.findById(id))) return ResponseEntity.status(HttpStatus.OK).body("Author is not exist!");
        AuthorDTO authorDTO = authorRepository.findAuthorById(AuthorDTO.class,id);
        AuthorAdnBookDTO authorAdnBookDTO = new AuthorAdnBookDTO();
        List<ThreeMostSellBookDTO> book = bookService.find3MostSoldBook(authorDTO.getId());
        authorAdnBookDTO.setAuthor(authorDTO);
        authorAdnBookDTO.setBook(book);
        authorAdnBookDTO.setNumberOfBooks(bookService.getNumberOfBooks(authorDTO));
        return new ResponseEntity<>(authorAdnBookDTO,HttpStatus.OK);
    }

    //Cập nhật tác giả
    @Override
    public ResponseEntity<String> updateAuthor(AuthorDTO authorDTO) {
        return saveAuthor(authorDTO);
    }

    //Xóa tác giả
    @Override
    public ResponseEntity<String> deleteAuthor(String id) {
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Delete Success!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Not found author!");
        }
    }

   }
