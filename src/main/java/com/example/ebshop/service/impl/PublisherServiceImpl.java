package com.example.ebshop.service.impl;

import com.example.ebshop.dto.SortForPublisher;
import com.example.ebshop.dto.response.PublisherAndBookDTO;
import com.example.ebshop.dto.response.PublisherDTO;
import com.example.ebshop.dto.response.TopSellingBooks;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Publisher;
import com.example.ebshop.repository.PublisherRepository;
import com.example.ebshop.service.BookService;
import com.example.ebshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookService bookService;

    //Thêm NXB
    @Override
    public ResponseEntity<String> save(Publisher publisher) {
        if (publisher.getPublisherId() == null) return ResponseEntity.status(HttpStatus.OK).body("Not found ID");
        if (publisher.getPublisherName() == null) return ResponseEntity.status(HttpStatus.OK).body("Not found name");
        publisherRepository.save(publisher);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }

    //tìm nhà xuất bản
    @Override
    public ResponseEntity<?> findById(String id) {
        PublisherDTO publisher = publisherRepository.findPublisherBypublisherId(PublisherDTO.class, id);
        PublisherAndBookDTO publisherAndBookDTO = new PublisherAndBookDTO();
        publisherAndBookDTO.setPublisherDTO(publisher);
        if (ObjectUtils.isEmpty(publisher)) return ResponseEntity.status(HttpStatus.OK).body("Not found!");
        List<TopSellingBooks> bookDTO = bookService.find5BestSellingBook(publisher);
        publisherAndBookDTO.setTopSellingBooks(bookDTO);
        Long count = bookService.getCountOfBookByPublisherId(publisher.getPublisherId());
        publisherAndBookDTO.setCount(count);
        return new ResponseEntity<>(publisherAndBookDTO, HttpStatus.OK);
    }

    //Update NXB
    @Override
    public ResponseEntity<String> update(Publisher publisher) {
        if (publisher.getPublisherId() == null) return ResponseEntity.status(HttpStatus.OK).body("Not found id!");
        PublisherDTO publisherDTO = publisherRepository.findPublisherBypublisherId(PublisherDTO.class, publisher.getPublisherId());
        if (ObjectUtils.isEmpty(publisherDTO)) return ResponseEntity.status(HttpStatus.OK).body("Not found publisher!");
        if (publisher.getPublisherName() == null) {
            publisher.setPublisherName(publisherDTO.getPublisherName());
        }
        publisherRepository.save(publisher);
        return ResponseEntity.status(HttpStatus.OK).body("Add success!");
    }

    //Xóa NXB
    @Override
    public ResponseEntity<String> deletePublisher(String id) {
        if (!publisherRepository.existsById(id)) return ResponseEntity.status(HttpStatus.OK).body("Not found!");
        if (bookService.checkPublisher(id))
            return ResponseEntity.status(HttpStatus.OK).body("There are still books in storage!");
        publisherRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
    }

    @Override
    public ResponseEntity<?> getBestseller() {
        List<PublisherDTO> publishers = publisherRepository.findAllBy(PublisherDTO.class);
        publishers.sort(new SortForPublisher());
        if (publishers.size() > 5) return ResponseEntity.status(HttpStatus.OK).body(publishers.subList(0, 4));
        return ResponseEntity.status(HttpStatus.OK).body(publishers);
    }

    @Override
    public void soldBook(List<OrderDetail> orderDetails) {
        for (OrderDetail orderDetail : orderDetails) {
            publisherRepository.soldBook(orderDetail.getQuantity(), orderDetail.getBook().getPublisher().getPublisherId());
        }
    }
}
