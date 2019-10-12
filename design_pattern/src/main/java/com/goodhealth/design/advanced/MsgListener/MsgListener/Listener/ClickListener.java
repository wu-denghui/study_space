package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName ClickListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/2 21:48
 * @Version 1.0
 **/
@Component
public class ClickListener extends AbstractMsgListener {
    @Override
    public void scan(MsgEvent msg) {
    }

    @Override
    public void clickMenu(MsgEvent msg) {
        System.out.println("处理点击事件");
    }

    @Override
    public void unKnown(MsgEvent msg) {

    }
}
