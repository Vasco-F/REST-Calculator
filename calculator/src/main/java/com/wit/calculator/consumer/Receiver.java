package com.wit.calculator.consumer;
import com.wit.calculator.services.CalculatorService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    
    @Autowired
    private CalculatorService calculatorService;

    @RabbitListener(queues = {"${queue.calculator.name}"})
    public void receive(@Payload String message){
        System.out.println("Received message: " + message);
        // calculatorService.handleOperation(message);
    }
}
