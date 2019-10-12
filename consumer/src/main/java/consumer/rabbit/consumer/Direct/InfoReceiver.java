package consumer.rabbit.consumer.Direct;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @author Administrator
 * @RabbitListener bindings:绑定队列
 *                  @QueueBinding  value:绑定队列的名称
 *                                      @Queue value:配置队列名称 autoDelete:是否是一个可删除的临时队列
 *                                      当所有消费客户端连接断开后，是否自动删除队列
 *                                  exchange:配置交换器
 *                                      @Exchange value:为交换器起个名称 type:指定具体的交换器类型,autoDelete 当所有绑定队列都不在使用时，是否自动删除交换器
 *                                  key 路由键
 *
 *
 *
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${rabbit.config.queue.info.name}",autoDelete = "true"),
                exchange = @Exchange(value = "${rabbit.config.exchange.direct.name}",type = ExchangeTypes.DIRECT,autoDelete = "true"),
                key = "${rabbit.config.queue.info.routingKey}"
        )
)
public class InfoReceiver {

    @RabbitHandler
    public void received(String mess){
        System.out.println("Info........receiver: "+mess);
    }
}
