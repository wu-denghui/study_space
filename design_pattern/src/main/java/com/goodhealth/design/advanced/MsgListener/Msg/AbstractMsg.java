package com.goodhealth.design.advanced.MsgListener.Msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AbstractMsg
 * @Description TODO
 * @Author WDH  抽象消息类
 * @Date 2019/8/22 20:12
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMsg {
    /** 文本消息 */
    public static final String MSG_TYPE_TEXT = "text";
    /** 图片消息 */
    public static final String MSG_TYPE_IMAGE = "image";
    /** 链接消息 */
    public static final String MSG_TYPE_LINK = "link";
    /** 事件消息 */
    public static final String MSG_TYPE_EVENT = "event";
    /**
     * 消息头
     */
    private MsgHeader header;

    /**
     * 预留操作
     */
    public abstract void preHandle();

    /**
     * 预留操作
     */
    public abstract void postHandle();

}
