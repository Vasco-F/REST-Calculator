package com.wit.rest.controllers;

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
    public String getSum(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b){

        JSONObject request = new JSONObject();
        request.put("op", "sum");
        request.put("a", a);
        request.put("b", b);

        producer.send(request);

        int result = a + b;

        JSONObject response = new JSONObject();
        response.put("result", result);

        return response.toString();
    }

    //TODO
    @GetMapping("/sub")
    public String getSub(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b){


        JSONObject response = new JSONObject();
        response.put("result", 0);

        return response.toString();
    }

    //TODO
    @GetMapping("/mult")
    public String getMult(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b){


        JSONObject response = new JSONObject();
        response.put("result", 0);

        return response.toString();
    }

    //TODO
    @GetMapping("/div")
    public String getDiv(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b){


        JSONObject response = new JSONObject();
        response.put("result", 0);

        return response.toString();
    }
    
}
