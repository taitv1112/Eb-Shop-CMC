package com.example.ebshop.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class CustomerDTO {
    private String name;
    @Email(regexp = "Email not avaliable")
    private String email;
    private String phone;
}
