package consumer.rabbit.consumer.Fanout;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @author Administrator
 * @RabbitListener bindings:绑定队列
 *                  @QueueBinding  value:绑定队列的名称
 *                                      @Queue value:配置队列名称 autoDelete:是否是一个可删除的临时队列
 *                                  exchange:配置交换器
 *                                      @Exchange value:为交换器起个名称 type:指定具体的交换器类型
 *                                  广播模式fanout不需要key 路由键
 *
 *
 *
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${rabbit.config.queue.message.name}",autoDelete = "true"),
                exchange = @Exchange(value = "${rabbit.config.exchange.fanout.name}",type = ExchangeTypes.FANOUT)
        )
)
public class MessageReceiver {

    @RabbitHandler
    public void received(String mess){
        System.out.println("Error........receiver: "+mess);
    }
}