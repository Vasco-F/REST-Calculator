package com.wit.calculator.exchange;
import com.wit.calculator.services.CalculatorService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CalculatorConsumer {
    
    @Autowired
    private CalculatorService calculatorService;

    @RabbitListener(queues = {"${queue.calculator.name}"})
    public String receive(@Payload String message){
        return calculatorService.handleOperation(message);
    }
}
