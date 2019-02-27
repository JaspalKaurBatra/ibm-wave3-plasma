package com.stackroute.plasma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.domain.Evaluator;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
   // ObjectMapper objectMapper = new ObjectMapper();

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse1.rabbitmq.routingkey}")
    private String routingkey1;
    // String kafkaTopic = "java_in_use_topic";


    public void send(Evaluator evaluator){
        rabbitTemplate.convertAndSend(exchange, routingkey1,evaluator);
        //System.out.println("Send msg = " + evaluator.getLevel());
    }
}
    