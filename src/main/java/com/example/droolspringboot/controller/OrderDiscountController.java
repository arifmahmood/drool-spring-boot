package com.example.droolspringboot.controller;

import com.example.droolspringboot.model.OrderDiscount;
import com.example.droolspringboot.model.OrderRequest;
import com.example.droolspringboot.service.OrderDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OrderDiscountController {

    private final OrderDiscountService orderDiscountService;

    public OrderDiscountController(OrderDiscountService orderDiscountService) {
        this.orderDiscountService = orderDiscountService;
    }

    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) throws IOException {
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}