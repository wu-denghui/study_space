package com.goodhealth.design.advanced.MsgListener.Session;

import com.goodhealth.design.advanced.MsgListener.Msg.*;

/**
 * @ClassName AbstractSessihandle
 * @Descriptihandle TODO
 * @Author WDH
 * @Date 2019/9/2 19:16
 * @Versihandle 1.0
 **/
public abstract class AbstractSession {

    public void process(AbstractMsg msg) {
        try {
            String type = msg.getHeader().getMsgType();
            //文本消息
            if(AbstractMsg.MSG_TYPE_TEXT.equals(type)){
                this.handleTextMsg((MsgText) msg);
            }else if(AbstractMsg.MSG_TYPE_IMAGE.equals(type)){
                this.handleImageMsg((MsgImage) msg);
            }else if(AbstractMsg.MSG_TYPE_EVENT.equals(type)){
                this.handleEventMsg((MsgEvent) msg);
            }else if(AbstractMsg.MSG_TYPE_LINK.equals(type)){
                this.handleLinkMsg((MsgLink) msg);
            }else{
                //这里暂时这样处理的
                this.handleErrorMsg(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 收到文本消息
     * @param msg
     */
    public abstract void handleTextMsg(MsgText msg);

    /**
     * 收到图片消息
     * @param msg
     */
    public abstract void handleImageMsg(MsgImage msg);

    /**
     * 收到事件推送消息
     * @param msg
     */
    public abstract void handleEventMsg(MsgEvent msg);

    /**
     * 收到链接消息
     * @param msg
     */
    public abstract void handleLinkMsg(MsgLink msg);

    /**
     * 错误消息
     * @param errorCode
     */
    public abstract void handleErrorMsg(int errorCode);
}
