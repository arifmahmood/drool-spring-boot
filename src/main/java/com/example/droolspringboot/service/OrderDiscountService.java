package com.example.droolspringboot.service;

import com.example.droolspringboot.config.DroolsConfig;
import com.example.droolspringboot.model.OrderDiscount;
import com.example.droolspringboot.model.OrderRequest;
import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class OrderDiscountService {

    private final DroolsConfig droolsConfig;

    public OrderDiscountService(DroolsConfig droolsConfig) {
        this.droolsConfig = droolsConfig;
    }


    public OrderDiscount getDiscount(OrderRequest orderRequest) throws IOException {

        OrderDiscount orderDiscount = new OrderDiscount();
        try {
            KieSession kieSession = droolsConfig.kieContainer().newKieSession();
            kieSession.setGlobal("orderDiscount", orderDiscount);
            kieSession.insert(orderRequest);
            kieSession.fireAllRules();
            kieSession.dispose();
        }catch (Exception e){

        }
        return orderDiscount;
    }
}