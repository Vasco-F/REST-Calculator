package com.wit.calculator.application;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.wit"} )
public class Application {

	@Value("${queue.calculator.name}")
	private String queueName;

	@Bean
	public Queue queue(){
		return new Queue(this.queueName, true);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
