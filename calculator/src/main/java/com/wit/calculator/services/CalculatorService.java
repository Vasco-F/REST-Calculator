package com.wit.calculator.services;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public String handleOperation(String message){
        JSONObject request = new JSONObject(message);

        String op = request.getString("op");

        JSONObject result = new JSONObject();
        switch (op){
            case "sum":
                result = handleSum(request);
                break;
            case "sub":
                result = handleSub(request);
                break;
            case "mult":
                result = handleMult(request);
                break;
            case "div":
                result = handleDiv(request);
                break;
            default:
                result = handleError();
        }
        return result.toString();
    }

    private JSONObject handleSum(JSONObject request){
        BigDecimal a = request.getBigDecimal("a");
        BigDecimal b = request.getBigDecimal("b");

        JSONObject result = new JSONObject();
        result.put("result", a.add(b));

        return result;
    }

    private JSONObject handleSub(JSONObject request){
        BigDecimal a = request.getBigDecimal("a");
        BigDecimal b = request.getBigDecimal("b");

        JSONObject result = new JSONObject();
        result.put("result", a.subtract(b));

        return result;
    }

    private JSONObject handleMult(JSONObject request){
        BigDecimal a = request.getBigDecimal("a");
        BigDecimal b = request.getBigDecimal("b");

        JSONObject result = new JSONObject();
        result.put("result", a.multiply(b));

        return result;
    }

    private JSONObject handleDiv(JSONObject request){
        BigDecimal a = request.getBigDecimal("a");
        BigDecimal b = request.getBigDecimal("b");

        JSONObject result = new JSONObject();
        result.put("result", a.divide(b));

        return result;
    }

    private JSONObject handleError(){

        JSONObject result = new JSONObject();
        result.put("result", "error!");

        return result;
    }
}
