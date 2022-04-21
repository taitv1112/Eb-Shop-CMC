package com.example.ebshop.dto;

import com.example.ebshop.dto.response.BestCustomerDTO;

import java.util.Comparator;

public class SortForCustomerBook implements Comparator<BestCustomerDTO> {
    @Override
    public int compare(BestCustomerDTO a, BestCustomerDTO b)
    {
        return a.getTotalBoughtBook().compareTo(b.getTotalBoughtBook());
    }

}
