package com.example.ebshop.service;

import com.example.ebshop.entity.Publisher;

public interface IPublisher {
    Publisher create (Publisher publisher);
    Publisher update (Publisher publisher);
    void delete (Publisher publisher);


}
