package com.example.droolspringboot.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String customerNumber;
    private Integer age;
    private Integer amount;
    private CustomerType customerType;
}
