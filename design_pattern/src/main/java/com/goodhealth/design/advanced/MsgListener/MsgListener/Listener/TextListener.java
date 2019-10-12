package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgText;

/**
 * @ClassName TextListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/4 19:41
 * @Version 1.0
 **/
public class TextListener extends AbstractMsgListener {
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
    public void handleTextMsg(MsgText msg) {
        System.out.println("处理文本消息");
    }
}
