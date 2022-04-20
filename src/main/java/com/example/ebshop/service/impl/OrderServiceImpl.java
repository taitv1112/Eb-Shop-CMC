package com.example.ebshop.service.impl;

import com.example.ebshop.config.exception.ExceptionHandling;
import com.example.ebshop.dto.request.OrderDTO;
import com.example.ebshop.dto.request.OrderDetailDTO;
import com.example.ebshop.dto.response.OrderInforDTO;
import com.example.ebshop.entity.Book;
import com.example.ebshop.entity.Customer;
import com.example.ebshop.entity.OrderDetail;
import com.example.ebshop.entity.Orders;
import com.example.ebshop.repository.IBookRepository;
import com.example.ebshop.repository.ICustomerReposiroty;
import com.example.ebshop.repository.IOrderDetailRepository;
import com.example.ebshop.repository.IOrderRepository;
import com.example.ebshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements IOrderService {
    static int id = 0;
    static int idO = 0;
    static int idOd = 0;
    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    IOrderDetailRepository iOrderDetailRepository;
    @Autowired
    ICustomerReposiroty iCustomerReposiroty;
    @Autowired
    IBookRepository iBookRepository;

    @Override
    @Transactional
    public void create(OrderDTO orderDTO) throws ExceptionHandling {
        Customer customer;
        if (iCustomerReposiroty.existsCustomerByEmail(orderDTO.getCustomerDTO().getEmail())) {
            customer = iCustomerReposiroty.findByEmail(orderDTO.getCustomerDTO().getEmail());
        } else {
            String idCustomer = "" + id;
            id++;
            customer = iCustomerReposiroty.save(new Customer(idCustomer, orderDTO.getCustomerDTO().getEmail(),orderDTO.getCustomerDTO().getPhone(), orderDTO.getCustomerDTO().getName()));
        }
        String idOrders = "" + idO;
        idO++;
        Orders orders = iOrderRepository.save(new Orders(idOrders, customer, IOrderService.PENDING));
        for (OrderDetailDTO o : orderDTO.getOrderDetailDTOS()) {
            Book book = iBookRepository.getById(o.getBookId());
            if (book.getStatus().equals("Delete")) {
                throw new ExceptionHandling("BAD_REQUEST", book.getName() + " is  Delete");
            }
            if (book.getQuantityCurrent() < o.getQuantity() || o.getQuantity() < 0) {
                throw new ExceptionHandling("BAD_REQUEST", book.getName() + " is " + book.getQuantityCurrent() + " available");
            }
            String idOrdersDetail = "" + idOd;
            idOd++;
            iOrderDetailRepository.save(new OrderDetail(idOrdersDetail, orders, book, o.getQuantity(), o.getPrice()));
            book.setQuantityCurrent(book.getQuantityCurrent() - o.getQuantity());
            book.setQuantitySold(book.getQuantitySold() + o.getQuantity());
            iBookRepository.save(book);
        }
    }

    @Override
    public OrderInforDTO inforOder(String id) {
        return new OrderInforDTO(iCustomerReposiroty.findByOrderById(id),iOrderDetailRepository.getOrderDetails(id),iOrderDetailRepository.totalBillByOrder(id));
    }

}
