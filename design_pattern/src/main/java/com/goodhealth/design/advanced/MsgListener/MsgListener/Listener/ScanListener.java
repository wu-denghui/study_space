package com.goodhealth.design.advanced.MsgListener.MsgListener.Listener;

import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;

/**
 * @ClassName ScanListener
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/4 19:42
 * @Version 1.0
 **/
public class ScanListener extends AbstractMsgListener {
    @Override
    public void scan(MsgEvent msg) {
        System.out.println("处理扫码事件");
    }

    @Override
    public void clickMenu(MsgEvent msg) {

    }

    @Override
    public void unKnown(MsgEvent msg) {

    }


}
