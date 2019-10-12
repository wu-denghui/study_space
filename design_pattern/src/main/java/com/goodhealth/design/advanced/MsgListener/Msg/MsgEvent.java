package com.goodhealth.design.advanced.MsgListener.Msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName MsgEvent
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/2 19:28
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
//构造hashcode和equal方法时，除了用自己的属性之外还使用从父类继承的属性来生成hashcode 默认为false
@EqualsAndHashCode(callSuper = true)
public class MsgEvent extends AbstractMsg {

    public enum EventType{

        SCAN("扫码事件",111),
        CLICK("点击事件",222),
        UNKOWN("未知事件",333);
         EventType(String type, int code){
            this.type = type;
            this.code = code;
        }
        private String type;
        private Integer code;
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }

    }
    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 发生时间
     */
    private Date happenTime;


    @Override
    public void preHandle() {

    }

    @Override
    public void postHandle() {

    }
}
