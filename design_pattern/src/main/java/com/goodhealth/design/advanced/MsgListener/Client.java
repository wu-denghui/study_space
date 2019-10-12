package com.goodhealth.design.advanced.MsgListener;

import com.goodhealth.design.advanced.MsgListener.MsgListener.Listener.ClickListener;
import com.goodhealth.design.advanced.MsgListener.MsgListener.Listener.ImageListener;
import com.goodhealth.design.advanced.MsgListener.Msg.AbstractMsg;
import com.goodhealth.design.advanced.MsgListener.Session.DefaultSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName Client
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/22 19:47
 * @Version 1.0
 **/
public class Client {

    @Autowired
    private ClickListener clickListener;

    @Autowired
    private ImageListener imageListener;

    public void action(AbstractMsg msg){
        DefaultSession  session =  DefaultSession.newInstance();
        session.addOnHandleMessageListener(clickListener);
        session.addOnHandleMessageListener(imageListener);
        //有多少监听器都可以加进来
        session.process(msg);
    }

}
