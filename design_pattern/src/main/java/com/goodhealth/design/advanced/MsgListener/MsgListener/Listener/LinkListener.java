package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgLink;

/**
 * @ClassName LinkListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/4 19:37
 * @Version 1.0
 **/
public class LinkListener extends AbstractMsgListener {
    @Override
    public void scan(MsgEvent msg) {

    }

    @Override
    public void clickMenu(MsgEvent msg) {

    }

    @Override
    public void unKnown(MsgEvent msg) {

    }

    @Override
    public void handleLinkMsg(MsgLink msg) {
        System.out.println("处理连接消息");
    }


}
