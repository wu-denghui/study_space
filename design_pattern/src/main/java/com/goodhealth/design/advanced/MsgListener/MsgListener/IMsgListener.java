package com.goodhealth.design.advanced.MsgListener.MsgListener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgImage;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgLink;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgText;

public interface IMsgListener {
    /**
     * 处理文本消息
     */
    void handleTextMsg(MsgText msgText);

    /**
     * 处理图片消息
     */
    void handleImageMsg(MsgImage msgImage);

    /**
     * 处理连接消息
     */
    void handleLinkMsg(MsgLink msgLink);
    /**
     * 处理事件消息
     */
    void handleEventMsg(MsgEvent msgEvent);
    /**
     * 错误消息
     * @param errorCode
     */
    void handleErrorMsg(int errorCode);

}
