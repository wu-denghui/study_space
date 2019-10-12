package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;

/**
 * @ClassName UnKownListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/4 19:48
 * @Version 1.0
 **/
public class UnKownListener extends AbstractMsgListener {
    @Override
    public void scan(MsgEvent msg) {

    }

    @Override
    public void clickMenu(MsgEvent msg) {

    }

    @Override
    public void unKnown(MsgEvent msg) {
        System.out.println("处理未知事件");
    }
}
