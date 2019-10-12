package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgImage;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgLink;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgText;
import com.goodhealth.design.advanced.MsgListener.MsgListener.IMsgListener;

/**
 * @ClassName AbstractMsgListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/2 19:18
 * @Version 1.0
 **/
public abstract class AbstractMsgListener implements IMsgListener {

    /**
     * 描码事件
     *
     * @param msg
     */
    public abstract void scan(MsgEvent msg);

    /**
     * 点击菜单事件
     *
     * @param msg
     */
    public abstract void clickMenu(MsgEvent msg);

    /**
     * 未知事件推送
     *
     * @param msg
     */
    public abstract void unKnown(MsgEvent msg);


    @Override
    public void handleEventMsg(MsgEvent msg) {
        /** 获得事件 **/
        String eventType = msg.getEventType();

        if (MsgEvent.EventType.CLICK.getType().equals(eventType)) {
            clickMenu(msg);
        } else if (MsgEvent.EventType.SCAN.getType().equals(eventType)) {
            scan(msg);
        } else {
            unKnown(msg);
        }
    }

    @Override
    public void handleTextMsg(MsgText msg) {
    }

    @Override
    public void handleImageMsg(MsgImage msg) {
    }

    @Override
    public void handleLinkMsg(MsgLink msg) {
    }

    @Override
    public void handleErrorMsg(int code){

    }


}
