package com.mq.consumer.Controller;

import com.mq.consumer.Config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;
import com.mq.consumer.DTO.testDTO;


@Component
public class ReceiveHandler {

    // 监听email队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_COUPON2USER})
    public void receive_email(testDTO msg) {
        System.out.println("num: " + msg.getNum());
        System.out.println("name: " + msg.getName());

    }
}

