package com.mq.consumer.Config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_COUPON2USER = "queue_coupon2user";
    public static final String EXCHANGE_TOPICS_ADDCOUPON2USER="exchange_topics_addcoupon2user";
    public static final String ROUTINGKEY_COUPON="inform.#.coupon.#";

    //声明交换机
    @Bean(EXCHANGE_TOPICS_ADDCOUPON2USER)
    public Exchange EXCHANGE_TOPICS_ADDCOUPON2USER(){
        //durable(true) 持久化，mq重启之后交换机还在
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_ADDCOUPON2USER).durable(true).build();
    }

    //声明QUEUE_INFORM_EMAIL队列
    @Bean(QUEUE_COUPON2USER)
    public Queue QUEUE_INFORM_EMAIL(){
        return new Queue(QUEUE_COUPON2USER);
    }

    //ROUTINGKEY_COUPON队列绑定交换机，指定routingKey
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_COUPON2USER) Queue queue,
                                              @Qualifier(EXCHANGE_TOPICS_ADDCOUPON2USER) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_COUPON).noargs();
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
