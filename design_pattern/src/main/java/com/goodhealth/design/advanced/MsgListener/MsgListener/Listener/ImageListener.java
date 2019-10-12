package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgImage;
import org.springframework.stereotype.Component;

/**
 * @ClassName ImageListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/2 21:45
 * @Version 1.0
 **/
@Component
public class ImageListener extends AbstractMsgListener {
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
    public void handleImageMsg(MsgImage msg) {
        System.out.println("处理图片消息");
    }
}
