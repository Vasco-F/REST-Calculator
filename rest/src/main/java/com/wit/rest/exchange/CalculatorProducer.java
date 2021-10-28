package com.wit.rest.exchange;

import org.json.JSONObject;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculatorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // @Autowired
    // private Queue queue;

    @Value("${queue.calculator.name}")
	private String calculatorQueue;

    public String send(JSONObject object){
        String message = object.toString();
        // rabbitTemplate.sendAndReceive(this.queue.getName(), message);

        String response = (String) rabbitTemplate.convertSendAndReceive(this.calculatorQueue, message);
        return response;
    }
}
