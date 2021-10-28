package com.wit.rest.exchange;

import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculatorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.calculator.name}")
	private String calculatorQueue;

    public String send(JSONObject object){
        String message = object.toString();

        String response = (String) rabbitTemplate.convertSendAndReceive(this.calculatorQueue, message);
        return response;
    }
}
