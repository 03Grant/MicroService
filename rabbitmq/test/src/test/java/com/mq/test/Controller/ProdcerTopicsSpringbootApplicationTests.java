package com.mq.test.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.mq.test.config.amqConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdcerTopicsSpringbootApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void Producer_topics_springbootTest() {

        //使用rabbitTemplate发送消息
        String message = "send email message to user";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
       // rabbitTemplate.convertAndSend(amqConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);
       // rabbitTemplate.convertAndSend(amqConfig.EXCHANGE_TOPICS_INFORM, "inform.sms", message);
    }
}
