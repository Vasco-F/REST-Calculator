package com.wit.rest.application;

import com.wit.rest.controllers.CalculatorController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.wit"} )
@EnableRabbit
public class Application {

	@Value("${queue.calculator.name}")
	private String calculatorQueue;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Queue queue(){
		return new Queue(this.calculatorQueue, true);
	}

	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger(CalculatorController.class);
	}
}
