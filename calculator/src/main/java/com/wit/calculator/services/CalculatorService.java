package com.wit.calculator.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public void handleOperation(String message){
        JSONObject request = new JSONObject(message);
    }
}
