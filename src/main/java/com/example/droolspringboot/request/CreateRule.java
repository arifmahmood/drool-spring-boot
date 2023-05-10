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
public class CreateRule {
    private String rulesFileData;

    private String fileName;
    private String global;
    private ArrayList<CustomRule> rules;

    public String getAsFormat(){

        StringBuilder rulesStatements = new StringBuilder();
        for (CustomRule rule : rules) {
            rulesStatements.append("\n").append(rule.getAsFormat());
        }

        String format =
                "import com.example.droolspringboot.model.OrderRequest;\n" +
                "import com.example.droolspringboot.model.CustomerType;\n" +
                "\n" +
                "global com.example.droolspringboot.model.OrderDiscount orderDiscount;\n" +
                "\n" +
                "dialect \"mvel\"\n" +
                rulesStatements;
        return format;
    }
}
