package com.wit.rest.controllers;

import java.math.BigDecimal;

import com.wit.rest.exchange.CalculatorProducer;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorProducer producer;

    @GetMapping("/")
    public String index(){
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/sum")
    public String getSum(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b){

        JSONObject request = requestHandler("sub", a, b);

        return producer.send(request);
    }

    @GetMapping("/sub")
    public String getSub(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b){

        JSONObject request = requestHandler("sub", a, b);

        return producer.send(request);
    }

    @GetMapping("/mult")
    public String getMult(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b){

        JSONObject request = requestHandler("mult", a, b);

        return producer.send(request);
    }

    @GetMapping("/div")
    public String getDiv(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b){

        JSONObject request = requestHandler("div", a, b);

        return producer.send(request);
    }

    /**
     * This private method is responsible to create the request body which should adopt the same format as 
     * the format expected by the calculator module
     * @param operation The operation code (sum, sub, mult, div)
     * @param a The first operand
     * @param b The second operand
     * @return The result of the operation applied to the given operands
     */
    private JSONObject requestHandler(String operation, BigDecimal a, BigDecimal b){
        JSONObject reqBody = new JSONObject();
        reqBody.put("op", operation);
        reqBody.put("a", a);
        reqBody.put("b", b);

        return reqBody;
    }
    
}
