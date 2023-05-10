package com.example.droolspringboot.controller;

import com.example.droolspringboot.request.CreateRule;
import com.example.droolspringboot.model.OrderDiscount;
import com.example.droolspringboot.service.DroolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/rule")
public class DroolController {

    private final DroolService droolService;

    public DroolController(DroolService droolService) {
        this.droolService = droolService;
    }

    @PostMapping("")
    public ResponseEntity<OrderDiscount> createRuleFile(@RequestBody CreateRule createRule) throws IOException {
        OrderDiscount discount = droolService.createRule(createRule);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

}
