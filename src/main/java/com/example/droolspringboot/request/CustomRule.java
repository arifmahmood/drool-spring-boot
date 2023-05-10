package com.example.droolspringboot.request;

public class CustomRule {
    private CustomCondition condition;


}

//
//rule "Age based discount"
//        when
//        OrderRequest(age < 20 || age > 50)
//        then
//        System.out.println("==========Adding 10% discount for Kids/ senior customer=============");
//        orderDiscount.setDiscount(orderDiscount.getDiscount() + 10);
//        end