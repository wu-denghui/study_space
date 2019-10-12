package com.goodhealth.design.advanced.MsgListener.Msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName MsgHeader
 * @Description TODO   抽象消息头 内含消息类该有的基本信息
 * @Author WDH
 * @Date 2019/8/22 20:12
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgHeader {
    /**
     * 发送者
     */
    private String fromName;
    /**
     * 接收者
     */
    private String toName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 消息类型
     */
    private String MsgType;

}
