package com.wit.calculator.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public String handleOperation(String message){
        JSONObject request = new JSONObject(message);

        String op = request.getString("op");
        int a = request.getInt("a");
        int b = request.getInt("b");

        JSONObject result = new JSONObject();
        result.put("result", a + b);

        System.out.println(result);

        return result.toString();

        // switch (op){
        //     case "sum":
                 
        // }
    }
}
