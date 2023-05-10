package com.example.droolspringboot.service;

import com.example.droolspringboot.request.CreateRule;
import com.example.droolspringboot.model.OrderDiscount;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class DroolService {


    public OrderDiscount createRule(CreateRule createRule) throws IOException {

        File file = new File("/Users/pathao/Desktop/snr/projects/drool-spring-boot/src/main/resources/rules/new-rule.drl");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(createRule.getRulesFileData().getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        return null;
    }
}
