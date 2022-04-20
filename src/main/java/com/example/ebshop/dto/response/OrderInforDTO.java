package com.example.ebshop.dto.response;

import com.example.ebshop.dto.request.CustomerDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderInforDTO {
    private ICustomerDTO customerDTO;
    private  List<InforOrderDetailDTO> orderDetailDTOList;
    private BigDecimal totalBill;

    public OrderInforDTO(ICustomerDTO customerDTO, List<InforOrderDetailDTO> orderDetailDTOList, BigDecimal totalBill) {
        this.customerDTO = customerDTO;
        this.orderDetailDTOList = orderDetailDTOList;
        this.totalBill = totalBill;
    }

    public OrderInforDTO() {
    }
}
