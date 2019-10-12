package com.goodhealth.provider.rabbit.provider.Topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author
 *
 */
@Component
public class OrderSender {

    @Autowired
    private AmqpTemplate  rabbitTemplate;

    @Value("${rabbitmq.config.exchange.topic.name}")
    private String exchange;

    public void sendInfo(String mess){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
    }

    public void sendError(String mess){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
    }
}
