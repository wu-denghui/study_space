package com.goodhealth.provider.rabbit.provider.Topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * 消息发送者
 * @author
 *
 */
@Component
public class UserSender {

    @Autowired
    private AmqpTemplate  rabbitTemplate;

    @Autowired
    private MessageDigest messageDigest;

    @Value("${rabbitmq.config.exchange.topic.name}")
    private String exchange;

    public void sendInfo(String msg, String routing ){
        //convertAndSend向消息队列发送消息 参数一：交换器名称。参数二：路由键 参数三：消息
        this.rabbitTemplate.convertAndSend(this.exchange,routing, "user.log.debug....."+msg);
    }


}
