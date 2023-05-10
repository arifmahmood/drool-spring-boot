package com.example.droolspringboot.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomRule {
    private String ruleName;
    private String condition;
    private ArrayList<String> actions;


    public String getAsFormat() {
        String delim = "    ";

        StringBuilder actionStatements = new StringBuilder();

        for (String action : actions) {
            actionStatements.append(delim).append(delim).append(action).append(";\n");
        }


        String format = "rule \"" + ruleName + "\"\n" +
                delim + "when\n" +
                delim + delim + condition + "\n" +
                delim + "then\n" +
                actionStatements+
                "end";

        return format;

    }
}


//
//rule "Age based discount"
//        when
//        OrderRequest(age < 20 || age > 50)
//        then
//        System.out.println("==========Adding 10% discount for Kids/ senior customer=============");
//        orderDiscount.setDiscount(orderDiscount.getDiscount() + 10);
//        end