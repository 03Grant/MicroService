package com.mq.test.Controller;

import com.mq.test.DTO.testDTO;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.mq.test.config.amqConfig;

@RestController
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/message")
    public String sendMessage(@RequestBody testDTO message) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend(amqConfig.EXCHANGE_TOPICS_ADDCOUPON2USER, "inform.coupon", message);
        return "Message sent: " + message;
    }
}

